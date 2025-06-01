
// import React from 'react';
// import { Navigate } from 'react-router-dom';

// const ProtectedRoute = ({ allowedRoles, children }) => {
//   const role = localStorage.getItem('role');

//   if (!allowedRoles.includes(role)) {
//     return <Navigate to="/home" replace />;
//   }

//   return children;
// };

// export default ProtectedRoute;


// src/Restriction/ProtectedRoute.js
// import React from 'react';
// import { Navigate } from 'react-router-dom';

// const ProtectedRoute = ({ deniedRoles = [], children }) => {
//   const role = (localStorage.getItem('role') || '').toLowerCase(); // Get and normalize role
//   const denied = deniedRoles.map(r => r.toLowerCase()); // Normalize denied roles

//   if (denied.includes(role)) {
//     return <Navigate to="/home" replace />;
//   }

//   return children;
// };

// export default ProtectedRoute;

import React from "react";
import { Navigate } from "react-router-dom";

const RoleProtectedRoute = ({ allowedRoles, children }) => {
  const role = localStorage.getItem("role");

  if (!role) {
    // If no role is found (user not logged in), redirect to login
    return <Navigate to="/login" />;
  }

  if (!allowedRoles.includes(role)) {
    // If user's role is not allowed, redirect to home
    return <Navigate to="/home" />;
  }

  // If allowed, show the component
  return children;
};

export default RoleProtectedRoute;
