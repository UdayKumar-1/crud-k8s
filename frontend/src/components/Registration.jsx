import { useState } from "react";
import "../App.css";
import Header from "./Header";
function Registration() {
  const [user, setUser] = useState({
    name: "uday",
    email: "hello",
    phoneNumber: "28388",
    password: "hello",
  });
  const onChangeValues = (e) => {
    const { name, value } = e.target;    
    setUser((prevUser) => ({
      ...prevUser,
      [name]: value,   
    }));
  };
  return (
    <>
      <Header></Header>
      <div className="container mt-5 text-center w-50">
        <form>
          <input
            type="text"
            name="name"
            value={user.name}
            placeholder="Enter your name"
            className="mainForm form-control w-50 m-auto"
            onChange={onChangeValues}
          />
          <br />
          <input
            type="email"
            name="email"
            value={user.email}
            placeholder="Enter your email"
            className="mainForm form-control w-50 m-auto"
            onChange={onChangeValues}
          />
          <br />
          <input
            type="text"
            name="phoneNumber"
            value={user.phoneNumber}
            placeholder="Enter your phoneNumber"
            className="mainForm form-control w-50 m-auto"
            onChange={onChangeValues}
          />
          <br />
          <input
            type="password"
            name="password"
            value={user.password}
            placeholder="Enter your password"
            className="mainForm form-control w-50 m-auto"
            onChange={onChangeValues}
          />
          <br />
          <button className="btn btn-primary">Registration</button>
        </form>
      </div>
    </>
  );
}

export default Registration;
