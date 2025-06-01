// import React, { useState, useEffect } from "react";
// import { useParams, Link } from "react-router-dom";
// import './Payments.css';

// function Payments() {
//   const { amcId } = useParams();
//   const [invoice, setInvoice] = useState(null);
//   const [billTo, setBillTo] = useState({
//     companyName: "",
//     companyEmail: "",
//     companyPhone: "",
//     companyAddress: "",
//   });
//   const [errorMessage, setErrorMessage] = useState(""); // State for error message

//   // Fetch Invoice and BillTo Data
//   useEffect(() => {
//     const fetchInvoiceDetails = async () => {
//       try {
//         // Fetch BillTo details
//         const billToResponse = await fetch(`http://localhost:8080/api/addAmcs/billToInvoice/${amcId}`);
//         const billToData = await billToResponse.json();
//         setBillTo(billToData);

//         // Fetch Invoice details
//         const invoiceResponse = await fetch(`http://localhost:8080/api/invoices/${amcId}`);
//         if (invoiceResponse.status === 404) {
//           // Handle case when no invoice is found
//           setErrorMessage("No invoice added for this AMC.");
//           setInvoice(null);
//         } else {
//           const invoiceData = await invoiceResponse.json();
//           setInvoice(invoiceData);
//           setErrorMessage(""); // Clear error message
//         }
//       } catch (error) {
//         console.error("Error fetching invoice details:", error);
//         setErrorMessage("An error occurred while fetching invoice details.");
//       }
//     };

//     fetchInvoiceDetails();
//   }, [amcId]);



//   if (errorMessage) {
//     return <div className="error-message">{errorMessage}</div>;
//   }

//   if (!invoice) {
//     return <div>Loading invoice details...</div>;
//   }

//   return (
//     <div className="invoice-container">
//       <Link to="/Dashboard" className="back-link">←</Link>
//       <div className="invoice-left">
//         <h3>Invoice</h3>
//         <p><strong>Invoice Number:</strong> {invoice.invoiceId}</p>

//         <div className="invoice-from">
//           <h3>From</h3>
//           <p><strong>Business Name:</strong> Nexa Soft</p>
//           <p><strong>Email Address:</strong> nexasoft@mail.com</p>
//           <p><strong>Phone Number:</strong> +123 4567 8910</p>
//           <p><strong>Address:</strong> Sri Lanka</p>
//         </div>

//         <div className="invoice-bill-to">
//           <h3>Bill To</h3>
//           <p><strong>Company Name:</strong> {billTo.companyName}</p>
//           <p><strong>Company Email:</strong> {billTo.companyEmail}</p>
//           <p><strong>Company Phone:</strong> {billTo.companyPhone}</p>
//           <p><strong>Company Address:</strong> {billTo.companyAddress}</p>
//         </div>
//       </div>

//       <div className="invoice-right">
//         <table className="invoice-table">
//           <thead>
//             <tr>
//               <th>Description</th>
//               <th>Amount</th>
//             </tr>
//           </thead>
//           <tbody>
//             {invoice.items.map((item, index) => (
//               <tr key={index}>
//                 <td>{item.description}</td>
//                 <td>{item.amount}</td>
//               </tr>
//             ))}
//           </tbody>
//         </table>

//         <div className="test1">
//           <div className="invoice-notes">
//             <h3>Notes</h3>
//             <p>{invoice.notes}</p>
//           </div>

//           <div className="invoice-terms">
//             <h3>Terms & Conditions</h3>
//             <p>{invoice.termsAndConditions}</p>
//           </div>
//         </div>
//         <div className="invoice-summary">
//           <p><strong>Tax:</strong> {invoice.tax}</p>
//           <p><strong>SubTotal:</strong> Rs {invoice.subTotal}</p>
//           <p className="due-balance">
//             <strong>Grand Total:</strong> Rs {invoice.grandTotal}
//           </p>
//         </div>
//       </div>
//     </div>
//   );
// }

// export default Payments;


import React, { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import './Payments.css';

function Payments() {
  const { amcId } = useParams();
  const [invoice, setInvoice] = useState(null);
  const [billTo, setBillTo] = useState({
    companyName: "",
    companyEmail: "",
    companyPhone: "",
    companyAddress: "",
  });
  const [errorMessage, setErrorMessage] = useState(""); // To hold error or pending message

  // Fetch Invoice and BillTo Data
  useEffect(() => {
    const fetchInvoiceDetails = async () => {
      try {
        // Fetch BillTo details
        const billToResponse = await fetch(`http://localhost:8080/api/addAmcs/billToInvoice/${amcId}`);
        const billToData = await billToResponse.json();
        setBillTo(billToData);

        // Fetch Invoice details
        const invoiceResponse = await fetch(`http://localhost:8080/api/invoices/${amcId}`);
        const invoiceData = await invoiceResponse.json();

        if (invoiceData && invoiceData.items && invoiceData.items.length > 0) {
          setInvoice(invoiceData);
        } else {
          setErrorMessage("Pending Invoice"); // Set the pending message
        }
      } catch (error) {
        setErrorMessage("Error fetching invoice details. Please try again.");
        console.error("Error fetching invoice details:", error);
      }
    };

    fetchInvoiceDetails();
  }, [amcId]);

  if (errorMessage === "Pending Invoice") {
    return (
      <div className="pending-container">
      
        <div className="pending-message">Pending Invoice</div>
        <div className="loading-icon"></div>
        <Link to="/Dashboard" className="back-link-p">Back To Dashboard</Link>
      </div>
    );
  }
  
  if (errorMessage) {
    return (
      <div className="invoice-container">
        <Link to="/Dashboard" className="back-link-p">Back To Dashboard</Link>
        <div className="error-message">{errorMessage}</div>
      </div>
    );
  }
  

  if (!invoice) {
    return <div>Loading invoice details...</div>;
  }

  return (
    <div className="invoice-container">
      <Link to="/Dashboard" className="back-link-p">←</Link>
      <div className="invoice-left">
        <h3>Invoice</h3>
        <p><strong>Invoice Number:</strong> {invoice.invoiceId}</p>

        <div className="invoice-from">
          <h3>From</h3>
          <p><strong>Business Name:</strong> Nexa Soft</p>
          <p><strong>Email Address:</strong> nexasoft@mail.com</p>
          <p><strong>Phone Number:</strong> +123 4567 8910</p>
          <p><strong>Address:</strong> Sri Lanka</p>
        </div>

        <div className="invoice-bill-to">
          <h3>Bill To</h3>
          <p><strong>Company Name:</strong> {billTo.companyName}</p>
          <p><strong>Company Email:</strong> {billTo.companyEmail}</p>
          <p><strong>Company Phone:</strong> {billTo.companyPhone}</p>
          <p><strong>Company Address:</strong> {billTo.companyAddress}</p>
        </div>
      </div>

      <div className="invoice-right">
        <table className="invoice-table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Amount</th>
            </tr>
          </thead>
          <tbody>
            {invoice.items.map((item, index) => (
              <tr key={index}>
                <td>{item.description}</td>
                <td>{item.amount}</td>
              </tr>
            ))}
          </tbody>
        </table>
                 <div className="test1">
         <div className="invoice-notes">
           <h3>Notes</h3>
            <p>{invoice.notes}</p>
          </div>

        <div className="invoice-terms">
            <h3>Terms & Conditions</h3>
            <p>{invoice.termsAndConditions}</p>
          </div>
        </div>

        <div className="invoice-summary">
          <p><strong>Tax:</strong> {invoice.tax}</p>
          <p><strong>SubTotal:</strong> Rs {invoice.subTotal}</p>
          <p className="due-balance">
            <strong>Grand Total:</strong> Rs {invoice.grandTotal}
          </p>
        </div>
      </div>
    </div>
  );
}

export default Payments;