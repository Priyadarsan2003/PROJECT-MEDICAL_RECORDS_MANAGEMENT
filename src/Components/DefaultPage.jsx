import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';


export default function DefaultPage() {
  const [showLoginForm, setShowLoginForm] = useState(false);
  const navigate = useNavigate();

  const toggleLoginForm = () => {
    setShowLoginForm(!showLoginForm);
  };

  const handleSignIn = () => {
    const username = document.getElementById('username').value;
    alert(`Welcome, ${username}!`);
    navigate('/home');
  };


  return (
    <div className="default-page">
      <button className="login-button" onClick={toggleLoginForm}>
        LOGIN
      </button>
      <h1 className="overlay-text">MEDICAL RECORDS MANAGEMENT</h1>
      <div className="text-section">
        <p className="text-line">"A RESTAPI project"</p>
        <p className="text-line">By: Priyadarsan S</p>
        <p className="text-line">2023-2024</p>
      </div>
      {showLoginForm && (
        <div className="login-form">
          <h2>Sign In</h2>
          <form>
            <div className="form-group">
              <label htmlFor="username">Username</label>
              <input type="text" id="username" name="username" />
            </div>
            <div className="form-group">
              <label htmlFor="userid">User ID</label>
              <input type="text" id="userid" name="userid" />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input type="password" id="password" name="password" />
            </div>
            <button type="submit" className="submit-button" onClick={handleSignIn}>
              Sign In
            </button>
          </form>
        </div>
      )}
    </div>
  );
}
