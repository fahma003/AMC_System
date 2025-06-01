





// import React, { useState, useEffect } from "react";
// import { useNavigate, useLocation } from "react-router-dom"; // Import useLocation
// import imageSrc from "../assets/werfdew.jpg.png";
// import "./NavigationBar.css";

// export default function NavigationBar() {
//   const [activeItem, setActiveItem] = useState("View AMC ▼");
//   const navigate = useNavigate();
//   const location = useLocation(); // Get the current location (URL)

//   useEffect(() => {
//     // Set the active item based on the current URL
//     if (location.pathname === "/feedback") {
//       setActiveItem("Feedback ▼");
//     } else if (location.pathname === "/payments") {
//       setActiveItem("Payments ▼");
//     } else if (location.pathname.includes("/project-details")) {
//       setActiveItem("View AMC ▼");
//     }
//   }, [location.pathname]); // Update when the path changes

  

//   const handleClick = (item) => {
//     setActiveItem(item);
//     switch (item) {
//       case "View AMC ▼":
//         const savedProject = localStorage.getItem("currentProject");
//         if (savedProject) {
//           const project = JSON.parse(savedProject);
//           navigate(`/project-details/${project.contractName}`);
//         } else {
//           alert("No AMC details available.");
//         }
//         break;
     
//       case "Feedback ▼":
//         navigate("/feedback");
//         break;
//       default:
//         break;
//     }
//   };
  

//   return (
//     <header className="nexa-header">
//       <img src={imageSrc} alt="nexasoft logo" className="logo" />
//       <div className="nav-bar-container">
//         <nav>
//           <ul className="nav-bar">
//             {["View AMC ▼", "Feedback ▼"].map((item) => (
//               <li
//                 key={item}
//                 className={activeItem === item ? "active" : ""}
//                 onClick={() => handleClick(item)}
//               >
//                 {item}
//               </li>
//             ))}
//           </ul>
//         </nav>
//       </div>
//     </header>
//   );
// }


import React, { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom"; // Import useLocation
import imageSrc from "../assets/werfdew.jpg.png";
import "./NavigationBar.css";

export default function NavigationBar() {
  const [activeItem, setActiveItem] = useState("View AMC ▼");
  const [showLogoutPopup, setShowLogoutPopup] = useState(false); // State for logout popup
  const navigate = useNavigate();
  const location = useLocation(); // Get the current location (URL)

  useEffect(() => {
    // Set the active item based on the current URL
    if (location.pathname === "/feedback") {
      setActiveItem("Feedback ▼");
    } else if (location.pathname.includes("/project-details")) {
      setActiveItem("View AMC ▼");
    }
  }, [location.pathname]); // Update when the path changes

  const handleClick = (item) => {
    setActiveItem(item);
    switch (item) {
      case "View AMC ▼":
        const savedProject = localStorage.getItem("currentProject");
        if (savedProject) {
          const project = JSON.parse(savedProject);
          navigate(`/project-details/${project.contractName}`);
        } else {
          alert("No AMC details available.");
        }
        break;
      case "Feedback ▼":
        navigate("/feedback");
        break;
      default:
        break;
    }
  };

  const handleLogout = () => {
    setShowLogoutPopup(true); // Show the logout popup
  };

  const confirmLogout = () => {
    setShowLogoutPopup(false);
    localStorage.removeItem("email"); // Clear user email or any authentication details
    navigate("/login"); // Redirect to the login page
  };

  const cancelLogout = () => {
    setShowLogoutPopup(false); // Hide the logout popup
  };

  return (
    <header className="nexa-header">
      <img src={imageSrc} alt="nexasoft logo" className="logo" />
      <div className="nav-bar-container">
        <nav>
          <ul className="nav-bar">
            {["View AMC ▼", "Feedback ▼"].map((item) => (
              <li
                key={item}
                className={activeItem === item ? "active" : ""}
                onClick={() => handleClick(item)}
              >
                {item}
              </li>
            ))}
          </ul>
        </nav>
        <div className="logout-icon-container" onClick={handleLogout}>
          <p className="logout-icon">🔓</p>
        </div>
      </div>
      {showLogoutPopup && (
        <div className="logout-popup">
          <p>Are you sure you want to logout?</p>
          <div className="popup-buttons">
            <button className="confirm-button" onClick={confirmLogout}>
              Yes
            </button>
            <button className="cancel-button2" onClick={cancelLogout}>
              No
            </button>
          </div>
        </div>
      )}
    </header>
  );
}