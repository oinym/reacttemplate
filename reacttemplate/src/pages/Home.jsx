import React from 'react';
import Login from "../component/Login";

export default function Home({children}) {
    return (
        <div>
            <h1>Login</h1>
            <Login/>
        </div>

    )
}