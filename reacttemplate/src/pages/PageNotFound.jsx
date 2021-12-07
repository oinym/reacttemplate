import React, {useContext} from 'react';
import {Link} from "react-router-dom";
import {UserContext} from "../jsutils/Authentication";

export default function PageNotFound() {
    const {user} = useContext(UserContext)

    return (
        <div>
            {
                user ?
                    <div>
                        <h1>Error page not found</h1>
                        <Link to="/about">return to about page</Link>
                    </div> :
                    <div>
                        <h1>You Must be logged in first </h1>
                        <Link to="/">Login</Link>
                    </div>
            }
        </div>
    )
}