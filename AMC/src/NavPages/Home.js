



// import React, { useState, useEffect } from "react";
// import { Link } from "react-router-dom";
// import { Bar, Line, Pie } from "react-chartjs-2";
// import {
//   Chart as ChartJS,
//   CategoryScale,
//   LinearScale,
//   PointElement,
//   LineElement,
//   BarElement,
//   Title,
//   Tooltip,
//   Legend,
//   Filler,
//   ArcElement,
// } from "chart.js";
// import './Home.css';

// // Register Chart.js components
// ChartJS.register(
//   CategoryScale,
//   LinearScale,
//   PointElement,
//   LineElement,
//   BarElement,
//   Title,
//   Tooltip,
//   Legend,
//   Filler,
//   ArcElement
// );

// function Home() {
//   // State for Monthly Costs data
//   const [monthlyCostsData, setMonthlyCostsData] = useState([]);
//   const [amcReminders, setAmcReminders] = useState([]);
//   const [totalUsers, setTotalUsers] = useState(0);
//   const [totalAmcData, setTotalAmcData] = useState([]);
//   const [dataOverview, setDataOverview] = useState([]);
//   const [categoryDistribution, setCategoryDistribution] = useState([]);

//   // Fetch data
//   useEffect(() => {
//     const fetchTotalAmcData = () => {
//       fetch("http://localhost:8080/api/addAmcs/amc-over-time")
//         .then((response) => response.json())
//         .then((data) => {
//           console.log("Total AMC Data:", data);
//           if (Array.isArray(data)) {
//             setTotalAmcData(data); // Ensure data is an array
//           } else {
//             console.error("Unexpected data format for Total AMC:", data);
//             setTotalAmcData([]);
//           }
//         })
//         .catch((error) => console.error("Error fetching Total AMC data:", error));
//     };

//     const fetchMonthlyCosts = () => {
//       fetch("http://localhost:8080/api/addAmcs/monthly-costs")
//         .then((response) => response.json())
//         .then((data) => {
//           console.log("Monthly Costs Data:", data);
//           setMonthlyCostsData(data);
//         })
//         .catch((error) => console.error("Error fetching Monthly Costs data:", error));
//     };

//     const fetchReminders = () => {
//       fetch("http://localhost:8080/api/addAmcs/amc-reminders")
//         .then((response) => response.json())
//         .then((data) => {
//           console.log("AMC Reminders Data:", data);
//           setAmcReminders(data);
//         })
//         .catch((error) => console.error("Error fetching AMC Reminders data:", error));
//     };

//     const fetchTotalUsers = () => {
//       fetch("http://localhost:8080/api/users/total-count")
//         .then((response) => response.json())
//         .then((data) => setTotalUsers(data.count)) // Assuming API returns { count: <number> }
//         .catch((error) => console.error("Error fetching Total Users:", error));
//     };

//     const fetchDataOverview = () => {
//       fetch("http://localhost:8080/api/feedback/data-overview") // Replace with your actual API endpoint
//         .then((response) => response.json())
//         .then((data) => setDataOverview(Array.isArray(data) ? data : []))
//         .catch((error) => console.error("Error fetching Data Overview:", error));
//     };

//     const fetchCategoryDistribution = () => {
//       fetch("http://localhost:8080/api/addAmcs/category-distribution")
//         .then((response) => response.json())
//         .then((data) => setCategoryDistribution(Array.isArray(data) ? data : []))
//         .catch((error) => console.error("Error fetching Category Distribution:", error));
//     };


//     // Initial data fetch
//     fetchTotalAmcData();
//     fetchMonthlyCosts();
//     fetchReminders();
//     fetchTotalUsers();
//     fetchDataOverview();
//     fetchCategoryDistribution();

//     // Polling every 60 seconds for live updates
//     const interval = setInterval(() => {
//       fetchTotalAmcData();
//       fetchMonthlyCosts();
//       fetchReminders();
//       fetchTotalUsers();
//       fetchDataOverview();
//       fetchCategoryDistribution();
//     }, 60000);

//     return () => clearInterval(interval);
//   }, []);

//   // Chart data for Total AMC (Line Chart)
//   const totalAmcChartData = {
//     labels: totalAmcData.map((item) => `${item.month}/${item.year}`), // X-axis labels (categories)
//     datasets: [
//       {
//         label: "Total AMC",
//         data: totalAmcData.map((item) => item.count), // Y-axis data
//         backgroundColor: "rgba(153, 102, 255, 0.2)",
//         borderColor: "rgb(181, 147, 249)",
//         borderWidth: 2,
//         tension: 0.3, // Smoothing for the line
//       },
//     ],
//   };

//   const monthlyChartData = {
//     labels: monthlyCostsData.map((item) => `Month ${item.month}`), // X-axis labels
//     datasets: [
//       {
//         label: "Monthly Costs",
//         data: monthlyCostsData.map((item) => item.totalCost), // Y-axis data
//         backgroundColor: "rgba(153, 102, 255, 0.2)",
//         borderColor: "rgba(153, 102, 255, 1)",
//         borderWidth: 1,
//       },
//     ],
//   };

//   // Chart data for Category Distribution (Pie Chart)
//   const categoryChartData = {
//     labels: categoryDistribution.map((item) => item.category),
//     datasets: [
//       {
//         data: categoryDistribution.map((item) => item.count),
//         backgroundColor: [
//           "#9B4DCA",
//           "#8E24AA", 
//           "#AB47BC",
//           "#D8A8E5",
//         ],
//         hoverBackgroundColor: [
//           "#9B4DCA",
//         "#8E24AA",
//         "#AB47BC",
//         "#D8A8E5",
//         ],

//       },
//     ],
//   };

//   return (
//     <div className="dashboard1">
//       <div className="dashboard-headers">
//         <Link to="/login" className="back-link">
//           ←
//         </Link>
//         <h2 className="dashboard-title">Dashboard</h2>
//       </div>

//       <div className="dashboard-container">
//         {/* Metrics Section */}
//         <div className="metrics-section">
//           {/* Total Revenues */}
//           <div className="total-revenue-card">
//             <h3>Total Revenues</h3>
//             <p>R 768,742</p>
//           </div>

//           {/* Total AMC and Active AMC */}
//           <div className="bottom-row">
//             <div className="metric-card">
//               <h4>Total AMC</h4>
//               <Line data={totalAmcChartData} />
//             </div>

//             <div className="metric-card">
//               <h4>Category Distribution</h4>
//               <Pie data={categoryChartData} />
//             </div>
//           </div>

//           {/* AMC Reminder and Total Users */}
//           <div className="bottom-row">
//             <div className="reminder-card">
//               <h4>AMC Reminder</h4>
//               <div className="reminder-list">
//                 {amcReminders.length > 0 ? (
//                   amcReminders.map((reminder, index) => (
//                     <p key={index} className="reminder-new">
//                       {reminder.contractName} - Due: {new Date(reminder.endDate).toLocaleDateString()}
//                     </p>
//                   ))
//                 ) : (
//                   <p>No upcoming reminders</p>
//                 )}
//               </div>
//             </div>

//             <div className="metric-card">
//               <h4>Total Users</h4>
//               <p className="metric-users">{totalUsers}</p>
//             </div>
//           </div>
//         </div>

//         {/* Data and Chart Section */}
//         <div className="data-chart-section">
//           {/* Data Overview */}
//           <div className="data-overview2">
//             <h4>Feedbacks</h4>
//             <ul className="data-list3">
//             {dataOverview.length > 0 ? (
//                 dataOverview.map((item, index) => (
//                   <li className="feedbackLists"  key={index}>{item.feedback}</li> 
//                 ))
//               ) : (
//                 <p>No data available</p>
//               )}
//             </ul>
//           </div>

//           {/* Monthly Costs Bar Chart */}
//           <div className="chart-section">
//             <h4>Monthly Costs Chart</h4>
//             <Bar data={monthlyChartData} />
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default Home;








// import React, { useState, useEffect } from "react";
// import { Link } from "react-router-dom";
// import { Bar, Line, Pie } from "react-chartjs-2";
// import {
//   Chart as ChartJS,
//   CategoryScale,
//   LinearScale,
//   PointElement,
//   LineElement,
//   BarElement,
//   Title,
//   Tooltip,
//   Legend,
//   Filler,
//   ArcElement,
// } from "chart.js";
// import './Home.css';


// ChartJS.register(
//   CategoryScale,
//   LinearScale,
//   PointElement,
//   LineElement,
//   BarElement,
//   Title,
//   Tooltip,
//   Legend,
//   Filler,
//   ArcElement
// );

// function Home() {
  
//   const [monthlyCostsData, setMonthlyCostsData] = useState([]);
//   const [amcReminders, setAmcReminders] = useState([]);
//   const [totalUsers, setTotalUsers] = useState(0);
//   const [totalAmcData, setTotalAmcData] = useState([]);
//   const [dataOverview, setDataOverview] = useState([]);
//   const [categoryDistribution, setCategoryDistribution] = useState([]);

 
//   useEffect(() => {
//     const fetchTotalAmcData = () => {
//       fetch("http://localhost:8080/api/addAmcs/amc-over-time")
//         .then((response) => response.json())
//         .then((data) => {
//           console.log("Total AMC Data:", data);
//           if (Array.isArray(data)) {
//             setTotalAmcData(data); 
//           } else {
//             console.error("Unexpected data format for Total AMC:", data);
//             setTotalAmcData([]);
//           }
//         })
//         .catch((error) => console.error("Error fetching Total AMC data:", error));
//     };

//     const fetchMonthlyCosts = () => {
//       fetch("http://localhost:8080/api/addAmcs/monthly-costs")
//         .then((response) => response.json())
//         .then((data) => {
//           console.log("Monthly Costs Data:", data);
//           setMonthlyCostsData(data);
//         })
//         .catch((error) => console.error("Error fetching Monthly Costs data:", error));
//     };

//     const fetchReminders = () => {
//       fetch("http://localhost:8080/api/addAmcs/amc-reminders")
//         .then((response) => response.json())
//         .then((data) => {
//           console.log("AMC Reminders Data:", data);
//           setAmcReminders(data);
//         })
//         .catch((error) => console.error("Error fetching AMC Reminders data:", error));
//     };

//     const fetchTotalUsers = () => {
//       fetch("http://localhost:8080/api/users/total-count")
//         .then((response) => response.json())
//         .then((data) => setTotalUsers(data.count)) // Assuming API returns { count: <number> }
//         .catch((error) => console.error("Error fetching Total Users:", error));
//     };

//     const fetchDataOverview = () => {
//       fetch("http://localhost:8080/api/feedback/data-overview") 
//         .then((response) => response.json())
//         .then((data) => setDataOverview(Array.isArray(data) ? data : []))
//         .catch((error) => console.error("Error fetching Data Overview:", error));
//     };

//     const fetchCategoryDistribution = () => {
//       fetch("http://localhost:8080/api/addAmcs/category-distribution")
//         .then((response) => response.json())
//         .then((data) => setCategoryDistribution(Array.isArray(data) ? data : []))
//         .catch((error) => console.error("Error fetching Category Distribution:", error));
//     };


  
//     fetchTotalAmcData();
//     fetchMonthlyCosts();
//     fetchReminders();
//     fetchTotalUsers();
//     fetchDataOverview();
//     fetchCategoryDistribution();

//     // Polling every 60 seconds for live updates
//     const interval = setInterval(() => {
//       fetchTotalAmcData();
//       fetchMonthlyCosts();
//       fetchReminders();
//       fetchTotalUsers();
//       fetchDataOverview();
//       fetchCategoryDistribution();
//     }, 60000);

//     return () => clearInterval(interval);
//   }, []);


//   const totalAmcChartData = {
//     labels: totalAmcData.map((item) => `${item.month}/${item.year}`), 
//     datasets: [
//       {
//         label: "Total AMC",
//         data: totalAmcData.map((item) => item.count), // Y-axis data
//         backgroundColor: "rgba(153, 102, 255, 0.2)",
//         borderColor: "rgb(181, 147, 249)",
//         borderWidth: 2,
//         tension: 0.3, // Smoothing for the line
//       },
//     ],
//   };

//   const monthlyChartData = {
//     labels: monthlyCostsData.map((item) => `Month ${item.month}`),
//     datasets: [
//       {
//         label: "Monthly Costs",
//         data: monthlyCostsData.map((item) => item.totalCost), 
//         backgroundColor: "rgba(153, 102, 255, 0.2)",
//         borderColor: "rgba(153, 102, 255, 1)",
//         borderWidth: 1,
//       },
//     ],
//   };

//   const categoryChartData = {
//     labels: categoryDistribution.map((item) => item.category),
//     datasets: [
//       {
//         data: categoryDistribution.map((item) => item.count),
//         backgroundColor: [
//           "#D1C4E9", 
//           "#7E57C2",
//           "#9575CD", 
//           "#B39DDB", 
//         ],
//         hoverBackgroundColor: [
//           "#D1C4E9", 
//           "#7E57C2",
//           "#9575CD", 
//           "#B39DDB", 
//         ],

//       },
//     ],
//   };

//   return (
//     <div className="dashboard1">
//       <div className="dashboard-headers">
//         <Link to="/login" className="back-link">
//           ←
//         </Link>
//         <h2 className="dashboard-title">Dashboard</h2>
//       </div>

//       <div className="dashboard-container">
       
//         <div className="metrics-section">
         
//           <div className="total-revenue-card">
//             <h3>Total Revenues</h3>
//             <p>Rs. 268,742</p>
//           </div>

         
//           <div className="bottom-row">
//             <div className="metric-card">
//               <h4>Total AMC</h4>
//               <Line data={totalAmcChartData} />
//             </div>

//             <div className="metric-card">
//               <h4>Category Distribution</h4>
//               <Pie data={categoryChartData} />
//             </div>
//           </div>

         
//           <div className="bottom-row">
//             <div className="reminder-card">
//               <h4>AMC Reminder</h4>
//               <div className="reminder-list">
//                 {amcReminders.length > 0 ? (
//                   amcReminders.map((reminder, index) => (
                    
//                     <p
//                     key={index}
//                     className="reminder-new"
//                     style={{ animationDelay: `${index * 0.3}s` }} 
//                   >
//                     {reminder.contractName} - Due: {new Date(reminder.endDate).toLocaleDateString()}
//                   </p>
//                   ))
//                 ) : (
//                   <p>No upcoming reminders</p>
//                 )}
//               </div>
//             </div>

//             <div className="metric-card">
//               <h4>Total Users</h4>
//               <p className="metric-users">{totalUsers}</p>
//             </div>
//           </div>
//         </div>

//         {/* Data and Chart Section */}
//         <div className="data-chart-section">
//           {/* Data Overview */}
//           <div className="data-overview2">
//             <h4>Feedbacks</h4>
//             <ul className="data-list3">
//             {dataOverview.length > 0 ? (
//                 dataOverview.map((item, index) => (
//                   <li className="feedbackLists"  key={index}>{item.feedback}</li> 
//                 ))
//               ) : (
//                 <p>No data available</p>
//               )}
//             </ul>
//           </div>

//           {/* Monthly Costs Bar Chart */}
//           <div className="chart-section">
//             <h4>Monthly Costs Chart</h4>
//             <Bar data={monthlyChartData} />
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default Home;





import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { Bar, Line, Pie } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  BarElement,
  Title,
  Tooltip,
  Legend,
  Filler,
  ArcElement,
} from "chart.js";
import './Home.css';


ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  BarElement,
  Title,
  Tooltip,
  Legend,
  Filler,
  ArcElement
);

function Home() {
  
  const [monthlyCostsData, setMonthlyCostsData] = useState([]);
  const [amcReminders, setAmcReminders] = useState([]);
  const [totalUsers, setTotalUsers] = useState(0);
  const [totalAmcData, setTotalAmcData] = useState([]);
  const [dataOverview, setDataOverview] = useState([]);
  const [categoryDistribution, setCategoryDistribution] = useState([]);

 
  useEffect(() => {
    const fetchTotalAmcData = () => {
      fetch("http://localhost:8080/api/addAmcs/amc-over-time")
        .then((response) => response.json())
        .then((data) => {
          console.log("Total AMC Data:", data);
          if (Array.isArray(data)) {
            setTotalAmcData(data); 
          } else {
            console.error("Unexpected data format for Total AMC:", data);
            setTotalAmcData([]);
          }
        })
        .catch((error) => console.error("Error fetching Total AMC data:", error));
    };

    const fetchMonthlyCosts = () => {
      fetch("http://localhost:8080/api/addAmcs/monthly-costs")
        .then((response) => response.json())
        .then((data) => {
          console.log("Monthly Costs Data:", data);
          setMonthlyCostsData(data);
        })
        .catch((error) => console.error("Error fetching Monthly Costs data:", error));
    };

    const fetchReminders = () => {
      fetch("http://localhost:8080/api/addAmcs/amc-reminders")
        .then((response) => response.json())
        .then((data) => {
          console.log("AMC Reminders Data:", data);
          setAmcReminders(data);
        })
        .catch((error) => console.error("Error fetching AMC Reminders data:", error));
    };

    const fetchTotalUsers = () => {
      fetch("http://localhost:8080/api/users/total-count")
        .then((response) => response.json())
        .then((data) => setTotalUsers(data.count)) // Assuming API returns { count: <number> }
        .catch((error) => console.error("Error fetching Total Users:", error));
    };

    const fetchDataOverview = () => {
      fetch("http://localhost:8080/api/feedback/data-overview") 
        .then((response) => response.json())
        .then((data) => setDataOverview(Array.isArray(data) ? data : []))
        .catch((error) => console.error("Error fetching Data Overview:", error));
    };

    const fetchCategoryDistribution = () => {
      fetch("http://localhost:8080/api/addAmcs/category-distribution")
        .then((response) => response.json())
        .then((data) => setCategoryDistribution(Array.isArray(data) ? data : []))
        .catch((error) => console.error("Error fetching Category Distribution:", error));
    };


  
    fetchTotalAmcData();
    fetchMonthlyCosts();
    fetchReminders();
    fetchTotalUsers();
    fetchDataOverview();
    fetchCategoryDistribution();

    // Polling every 60 seconds for live updates
    const interval = setInterval(() => {
      fetchTotalAmcData();
      fetchMonthlyCosts();
      fetchReminders();
      fetchTotalUsers();
      fetchDataOverview();
      fetchCategoryDistribution();
    }, 60000);

    return () => clearInterval(interval);
  }, []);


  const totalAmcChartData = {
    labels: totalAmcData.map((item) => `${item.month}/${item.year}`), 
    datasets: [
      {
        label: "Total AMC",
        data: totalAmcData.map((item) => item.count), // Y-axis data
        backgroundColor: "rgba(153, 102, 255, 0.2)",
        borderColor: "rgb(181, 147, 249)",
        borderWidth: 2,
        tension: 0.3, // Smoothing for the line
      },
    ],
  };

  // const monthlyChartData = {
  //   labels: monthlyCostsData.map((item) => `Month ${item.month}`),
  //   datasets: [
  //     {
  //       label: "Monthly Costs",
  //       data: monthlyCostsData.map((item) => item.totalCost), 
  //       backgroundColor: "rgba(153, 102, 255, 0.2)",
  //       borderColor: "rgba(153, 102, 255, 1)",
  //       borderWidth: 1,
  //     },
  //   ],
  // };

  const monthlyChartData = {
    labels: Array.isArray(monthlyCostsData) ? monthlyCostsData.map((item) => `Month ${item.month}`) : [],
    datasets: [
      {
        label: "Monthly Costs",
        data: Array.isArray(monthlyCostsData) ? monthlyCostsData.map((item) => item.totalCost) : [],
        backgroundColor: "rgba(153, 102, 255, 0.2)",
        borderColor: "rgba(153, 102, 255, 1)",
        borderWidth: 1,
      },
    ],
  };
  

  const categoryChartData = {
    labels: categoryDistribution.map((item) => item.category),
    datasets: [
      {
        data: categoryDistribution.map((item) => item.count),
        backgroundColor: [
          "#D1C4E9", 
          "#7E57C2",
          "#9575CD", 
          "#B39DDB", 
        ],
        hoverBackgroundColor: [
          "#D1C4E9", 
          "#7E57C2",
          "#9575CD", 
          "#B39DDB", 
        ],

      },
    ],
  };

  return (
    <div className="dashboard1">
      <div className="dashboard-headers">
        <Link to="/login" className="back-link">
          ←
        </Link>
        <h2 className="dashboard-title">Dashboard</h2>
      </div>

      <div className="dashboard-container">
       
        <div className="metrics-section">
         
          <div className="total-revenue-card">
            <h3>Total Revenues</h3>
            <p>Rs. 268,742</p>
          </div>

         
          <div className="bottom-row">
            <div className="metric-card">
              <h4>Total AMC</h4>
              <Line data={totalAmcChartData} />
            </div>

            <div className="metric-card">
              <h4>Category Distribution</h4>
              <Pie data={categoryChartData} />
            </div>
          </div>

         
          <div className="bottom-row">
            <div className="reminder-card">
              <h4>AMC Reminder</h4>
              <div className="reminder-list">
                {amcReminders.length > 0 ? (
                  amcReminders.map((reminder, index) => (
                    
                    <p
                    key={index}
                    className="reminder-new"
                    style={{ animationDelay: `${index * 0.3}s` }} 
                  >
                    {reminder.contractName} - Due: {new Date(reminder.endDate).toLocaleDateString()}
                  </p>
                  ))
                ) : (
                  <p>No upcoming reminders</p>
                )}
              </div>
            </div>

            <div className="metric-card">
              <h4>Total Users</h4>
              <p className="metric-users">{totalUsers}</p>
            </div>
          </div>
        </div>

        {/* Data and Chart Section */}
        <div className="data-chart-section">
          {/* Data Overview */}
          <div className="data-overview2">
            <h4>Feedbacks</h4>
            <ul className="data-list3">
            {dataOverview.length > 0 ? (
                dataOverview.map((item, index) => (
                  <li className="feedbackLists"  key={index}>{item.feedback}</li> 
                ))
              ) : (
                <p>No data available</p>
              )}
            </ul>
          </div>

          {/* Monthly Costs Bar Chart */}
          <div className="chart-section">
            <h4>Monthly Costs Chart</h4>
            <Bar data={monthlyChartData} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
