    import React, { useEffect, useState } from 'react';
    import axios from 'axios';
    
    export default function RecordList() {
      const [records, setRecords] = useState([]);
    
      useEffect(() => {
        axios.get('http://127.0.0.1:8080/showDetails')
          .then((response) => {
            setRecords(response.data);
          })
          .catch((error) => {
            console.error(error);
          });
      }, []);
    
      return (
        <div className="record-list">
          <h2>Records</h2>
          <table className="record-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Patient Name</th>
                <th>Patient Age</th>
                <th>Admitted Date</th>
                <th>Discharge Date</th>
              </tr>
            </thead>
            <tbody>
              {records.map((record) => (
                <tr key={record.patientId}>
                  <td>{record.patientId}</td>
                  <td>{record.patientName}</td>
                  <td>{record.patientAge}</td>
                  <td>{record.admittedDate}</td>
                  <td>{record.dischargeDate}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      );
    }
    
