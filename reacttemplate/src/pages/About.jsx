import React, {useContext} from 'react';
import {UserContext} from "../jsutils/Authentication";

export default function About(){
const {user}=useContext(UserContext)

return(
<div>
<h1>This is an Aboout page {user}</h1>
</div>
)
}