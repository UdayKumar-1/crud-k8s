import { useEffect, useState } from "react";
import Header from "./Header";
const CrudOperation = () => {
  const [inputText, setInputText] = useState({
    text: "",
    userId: "",
  });
  const [allData, setAllData] = useState([]);
  const handleOnChange = (e) => {
    console.log("e.target.value ", e.target.value);
    setInputText({ ...inputText, text: e.target.value });
  };
  return (
    <>
      <Header />
      <div className="container">
        <div className="d-flex justify-content-center my-2">
          <input
            type="text"
            onChange={(e) => handleOnChange(e)}
            className="form-control w-25"
          />
          <button className="btn btn-primary mx-2" onClick={()=>{}}>
            Add
          </button>
        </div>
        {typeof allData == "string" && (
          <div className="d-flex justify-content-center">
            There are no Tasks
          </div>
        )}
        {allData.length > 0 &&
          typeof allData != "string" &&
          allData?.map((item, index) => (
            <div
              className="row g-0 w-75 py-2 rounded-3 mt-1 d-flex justify-content-center mx-4"
              key={index}
            >
              <div className="col-sm-4"></div>
              <div className="col-sm-2">
                <span>{item.user.name}</span>
              </div>
              <div className="col-sm-3">
                <span>{item.text}</span>
              </div>
              <div
                className="col-sm-1 "
                onClick={() =>{}}
              >
                ❌
              </div>
            </div>
          ))}
      </div>
    </>
  );
};

export default CrudOperation;
