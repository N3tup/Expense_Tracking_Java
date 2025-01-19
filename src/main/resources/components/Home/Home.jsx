// components/Home.jsx
import React from 'react';
import { useNavigate } from 'react-router-dom';
import './Home.css';

const Home = () => {
    const navigate = useNavigate();

    return (
        <div className="home-container">
            <div className="home-content">
                <h1>Welcome to Expense Tracking Application</h1>
                <p>Manage your expenses easily and efficiently</p>
                <div className="button-group">
                    <button onClick={() => navigate('/login')} className="btn btn-primary">
                        Login
                    </button>
                    <button onClick={() => navigate('/register')} className="btn btn-secondary">
                        Register
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Home;
