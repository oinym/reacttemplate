import React, {useState} from 'react';
import {Redirect} from "react-router-dom";
export const UserContext=React.createContext(null);


export default function Authentication({children}){
    const [user,setUser]=useState(null);

    function login(user,password,callback){
        //validate user at your own will...
        setUser(user);
        // callback(()=>window.open("/about"));
    }
    function logout(callback){
        setUser(null);
        callback(()=><Redirect to={"/"}/>);
    }
    return(
        <UserContext.Provider value={{user,login,logout}}>
            {children}
        </UserContext.Provider>
    )

}