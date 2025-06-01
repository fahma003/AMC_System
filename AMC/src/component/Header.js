// import React, { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import imageSrc from "../assets/werfdew.jpg.png";
// import { FiLogOut } from "react-icons/fi";
// import "./Header.css";

// export default function Header() {
//   const [activeItem, setActiveItem] = useState("HOME");
//   const [showPopup, setShowPopup] = useState(false);
//   const navigate = useNavigate();


//  // Read role from localStorage and normalize to uppercase for consistency
//  const role = localStorage.getItem("role")?.toUpperCase() || "";

//  // Define all nav items
//  const allNavItems = ["HOME ▼", "INVOICE ▼", "REPORTS ▼", "ADD USER ▼", "ADD AMC ▼"];

//  // Filter nav items based on role
//  const navItems = allNavItems.filter(item => {
//    if (role === "ACCOUNTANT") {
//      // Accountant should NOT see ADD USER and ADD AMC
//      if (item === "ADD USER ▼" || item === "ADD AMC ▼") {
//        return false;
//      }
//    }
//    return true; // For other roles, show all
//  });




//   const handleClick = (item) => {
//     setActiveItem(item);
//   switch (item) {
//     case "HOME ▼":
//       navigate("/home");
//       break;
    
//     case "INVOICE ▼":
//       navigate("/invoice");
//       break;
//     case "REPORTS ▼":
//       navigate("/report");
//       break;
//     case "ADD USER ▼":
//       navigate("/adduser");
//       break;
//     case "ADD AMC ▼":
//       navigate("/addAmc");
//       break;
//     default:
//       break;
//     }
//   };


//   const handleLogoutClick = () => {
//     setShowPopup(true); // Show the custom popup
//   };

//   const confirmLogout = () => {
//     setShowPopup(false);
//     navigate("/login"); // Redirect to login page
//   };

//   const cancelLogout = () => {
//     setShowPopup(false); // Close the popup without logging out
//   };

//   return (
//     <header className="header-navv">
//       <img src={imageSrc} alt="nexasoft logo" className="logo" />
//       <nav>
//         <ul className="nav-page">
//           {["HOME ▼", "INVOICE ▼", "REPORTS ▼", "ADD USER ▼", "ADD AMC ▼"].map((item) => (
//             <li
//               key={item}
//               className={activeItem === item ? "active" : ""}
//               onClick={() => handleClick(item)}
//             >
//               {item}
//             </li>
//           ))}
//         </ul>
//       </nav>
//       <div className="right-section1">
       
//         <FiLogOut className="logout-icon" onClick={handleLogoutClick} />
//       </div>

//       {showPopup && (
//         <div className="popup-overlay">
//           <div className="popup-logout">
//             <h3>Confirm Logout</h3>
//             <p>Are you sure you want to logout?</p>
//             <div className="popup-buttons-logout">
//               <button onClick={confirmLogout} className="confirm-button-logout">
//                 Yes
//               </button>
//               <button onClick={cancelLogout} className="cancel-button-logout">
//                 No
//               </button>
//             </div>
//           </div>
//         </div>
//       )}
//     </header>
//   );
// }



import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import imageSrc from "../assets/werfdew.jpg.png";
import { FiLogOut } from "react-icons/fi";
import "./Header.css";

export default function Header() {
  const [activeItem, setActiveItem] = useState("HOME");
  const [showPopup, setShowPopup] = useState(false);
  const navigate = useNavigate();

  // Read role from localStorage and normalize to uppercase for consistency
  const role = localStorage.getItem("role")?.toUpperCase() || "";

  // Define all nav items
  const allNavItems = ["HOME ▼", "INVOICE ▼", "REPORTS ▼", "ADD USER ▼", "ADD AMC ▼"];

  // Filter nav items based on role
  const navItems = allNavItems.filter(item => {
    if (role === "ACCOUNTANT") {
      // Accountant should NOT see ADD USER and ADD AMC
      if (item === "ADD USER ▼" || item === "ADD AMC ▼") {
        return false;
      }
    }
    return true; // For other roles, show all
  });

  const handleClick = (item) => {
    setActiveItem(item);
    switch (item) {
      case "HOME ▼":
        navigate("/home");
        break;
      case "INVOICE ▼":
        navigate("/invoice");
        break;
      case "REPORTS ▼":
        navigate("/report");
        break;
      case "ADD USER ▼":
        navigate("/adduser");
        break;
      case "ADD AMC ▼":
        navigate("/addAmc");
        break;
      default:
        break;
    }
  };

  const handleLogoutClick = () => {
    setShowPopup(true);
  };

  const confirmLogout = () => {
    setShowPopup(false);
    navigate("/login");
  };

  const cancelLogout = () => {
    setShowPopup(false);
  };

  return (
    <header className="header-navv">
      <img src={imageSrc} alt="nexasoft logo" className="logo" />
      <nav>
        <ul className="nav-page">
          {navItems.map((item) => (
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
      <div className="right-section1">
        <FiLogOut className="logout-icon" onClick={handleLogoutClick} />
      </div>

      {showPopup && (
        <div className="popup-overlay">
          <div className="popup-logout">
            <h3>Confirm Logout</h3>
            <p>Are you sure you want to logout?</p>
            <div className="popup-buttons-logout">
              <button onClick={confirmLogout} className="confirm-button-logout">
                Yes
              </button>
              <button onClick={cancelLogout} className="cancel-button-logout">
                No
              </button>
            </div>
          </div>
        </div>
      )}
    </header>
  );
}
