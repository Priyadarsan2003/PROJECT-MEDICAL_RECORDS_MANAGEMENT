import React, { useState } from 'react';
// import { Link } from 'react-router-dom';
import RecordForm from './Post';
import RecordList from './Get';

export default function Home() {
  const [showRecordForm, setShowRecordForm] = useState(false);
  const [showRecordList, setShowRecordList] = useState(false);

  const toggleRecordForm = () => {
    setShowRecordForm(!showRecordForm);
    setShowRecordList(false); // Hide RecordList when showing RecordForm
  };

  const toggleRecordList = () => {
    setShowRecordList(!showRecordList);
    setShowRecordForm(false); // Hide RecordForm when showing RecordList
  };

  return (
    <div>
      <nav className="navbar">
        <div className="nav-links">
          <a href="#header" className="nav-link">
            Home
          </a>
          <a href="#about" className="nav-link">
            About
          </a>
          <a href="#post" className="nav-link" onClick={toggleRecordForm}>
            Post
          </a>
          <a href="#records" className="nav-link" onClick={toggleRecordList}>
            Records
          </a>
          <a href="#contact" className="nav-link">
            Contacts
          </a>
        </div>
      </nav>
      <header className="header" id="header">
        <h1>Welcome to the Medical Records Management System</h1>
      </header>
      <section className="about" id="about">
        <h2>About</h2>
        <p>This is RESTAPI project done by Priyadarsan S, III-ECE-B, for the academic year 2023-2024.</p>
        <p>This project is done using STS workspace, MySQL workbench, React (VS CODE) and </p>
        <p>java programming.</p>
        <br></br>
        <p> The project is Medical Records Management.</p>
        <p> This project is consists of 3 tables, namely, patients records, doctor records and medicine </p>
        <p> records.</p>
        <br></br>
        <p>The projects contains various functions that can be used to access data through Postman</p>
        <p> by specifying needed endpoints.</p>
        <br></br>
        <p>Some controller (endpoints) and services</p>
        <ul>
            <li>"/add" - add records</li>
            <li>"/showDetails" - displays records</li>
            <li>"/updateDetails" - updates data in a record</li>
            <li>"/deleteDetails" - deletes record from table</li>
            <li>"sort/filed" - sorts record by field specified</li>
            <li>"paging/no/size" - paging</li>
        </ul>
      </section>
      <section className="post" id="post">
        {showRecordForm && <RecordForm />} {/* Render RecordForm conditionally */}
      </section>
      <section className="records" id="records">
        {showRecordList && <RecordList />} {/* Render RecordList conditionally */}
      </section>
      <section className="contact" id="contact">
        <h2>Contact Information</h2>
        <ul>
          <li>Mobile: 89739 19199</li>
          <li>Email: 727721euec117@skcet.ac.in</li>
          <li>GitHub:<a href='https://github.com/Priyadarsan2003'>https://github.com/Priyadarsan2003</a></li>
        </ul>
      </section>
    </div>
  );
}
