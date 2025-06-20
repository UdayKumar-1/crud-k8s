import { useState } from "react";
import Header from "./Header";

const Login = () => {
  const [user, setUser] = useState({
    email: "",
    password: "",
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
      <Header />
      <div className="container mt-5 text-center w-50">
        <form>
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
            type="password"
            name="password"
            value={user.password}
            placeholder="Enter your password"
            className="mainForm form-control w-50 m-auto"
            onChange={onChangeValues}
          />
          <br />
          <button className="btn btn-primary">Login</button>
        </form>
      </div>
    </>
  );
};

export default Login;
