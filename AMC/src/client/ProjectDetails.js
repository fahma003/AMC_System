


// import React, { useEffect, useState } from "react";
// import { useParams, useNavigate } from "react-router-dom";
// import "./ProjectDetails.css";
// import axios from "axios";
// import NavigationBar from "./NavigationBar";

// const ProjectDetails = () => {
//   const { contractName } = useParams();
//   const [project, setProject] = useState(null);
//   const [error, setError] = useState("");
//   const navigate = useNavigate();

//   useEffect(() => {
//     const getProjectDetails = async () => {
//       try {
//         const response = await axios.get(
//           `http://localhost:8080/api/addAmcs/projectDetails/${contractName}`
//         );

//         if (response.data && response.data.length > 0) {
//           const projectData = response.data[0];
//           setProject(projectData);
//           localStorage.setItem("currentProject", JSON.stringify(projectData)); // Save to localStorage
//         } else {
//           setError("No project details found for this contract.");
//         }
//       } catch (err) {
//         setError("Error fetching project details. Please try again.");
//       }
//     };

//     getProjectDetails();
//   }, [contractName]);

//   if (error) {
//     return <div className="error-message">{error}</div>;
//   }

//   if (!project) {
//     return <div>Loading project details...</div>;
//   }

//   return (
//     <>
//       <NavigationBar />
//       <div className="project-details-container">
//         <h2>{project.contractName}</h2>
//         <p>
//           <strong>AMCID:</strong> {project.amcId}
//         </p>
//         <p>
//           <strong>Category:</strong> {project.category}
//         </p>
//         <p>
//           <strong>Description:</strong> {project.description}
//         </p>
//         <p>
//           <strong>Start Date:</strong> {project.startDate}
//         </p>
//         <p>
//           <strong>End Date:</strong> {project.endDate}
//         </p>
//         <p>
//           <strong>Cost:</strong> {project.cost}
//         </p>

//         <button onClick={() => navigate("/dashboard")}>Back</button>
//       </div>
//     </>
//   );
// };

// export default ProjectDetails;


import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./ProjectDetails.css";
import axios from "axios";
import NavigationBar from "./NavigationBar";

const ProjectDetails = () => {
  const { contractName } = useParams();
  const [project, setProject] = useState(null);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const getProjectDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/addAmcs/projectDetails/${contractName}`
        );

        if (response.data && response.data.length > 0) {
          const projectData = response.data[0];
          setProject(projectData);
          localStorage.setItem("currentProject", JSON.stringify(projectData)); // Save to localStorage
        } else {
          setError("No project details found for this contract.");
        }
      } catch (err) {
        setError("Error fetching project details. Please try again.");
      }
    };

    getProjectDetails();
  }, [contractName]);

  if (error) {
    return <div className="error-message">{error}</div>;
  }

  if (!project) {
    return <div>Loading project details...</div>;
  }

  return (
    <>
      <NavigationBar />
      <div className="project-details-container">
        <h2>{project.contractName}</h2>
        <p>
          <strong>AMCID:</strong> {project.amcId}
        </p>
        <p>
          <strong>Category:</strong> {project.category}
        </p>
        <p>
          <strong>Description:</strong> {project.description}
        </p>
        <p>
          <strong>Start Date:</strong> {project.startDate}
        </p>
        <p>
          <strong>End Date:</strong> {project.endDate}
        </p>
        <p>
          <strong>Cost:</strong> {project.cost}
        </p>

        
<div className="button-container">
  {/* View Invoice Button */}
  <button
    onClick={() => navigate(`/payments/${project.amcId}`)}
    className="view-invoice-btn"
  >
    View Invoice
  </button>

  {/* Back Button */}
  <button
    onClick={() => navigate("/dashboard")}
    className="back-btn"
  >
    Back
  </button>
</div>


      </div>
    </>
  );
};

export default ProjectDetails;