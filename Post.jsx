import React, { useState } from 'react';
import axios from 'axios';

export default function RecordForm() {
  const [formData, setFormData] = useState({
    patientId: '',
    patientName: '',
    patientAge: '',
    admittedDate: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://127.0.0.1:8080/add', formData);
      alert("Records added!");
      console.log(response.data);

      setFormData({
        patientId: '',
        patientName: '',
        patientAge: '',
        admittedDate: '',
      });
    } catch (error) {
      console.error('Error adding record:', error);
    }
  };

  return (
    <div>
      <h2>Add Record</h2>
      <form onSubmit={handleSubmit} className='record-form'>
        <div>
          <label htmlFor="patientId">Patient ID:</label>
          <input
            type="text"
            id="patientId"
            name="patientId"
            value={formData.patientId}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="patientName">Patient Name:</label>
          <input
            type="text"
            id="patientName"
            name="patientName"
            value={formData.patientName}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="patientAge">Patient Age:</label>
          <input
            type="number"
            id="patientAge"
            name="patientAge"
            value={formData.patientAge}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="admittedDate">Admitted Date:</label>
          <input
            type="date"
            id="admittedDate"
            name="admittedDate"
            value={formData.admittedDate}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Add Record</button>
      </form>
    </div>
  );
}
