import { useEffect, useState } from "react";
import Header from "./Header";
import axios from "axios";
const CrudOperation = () => {
  const [inputText, setInputText] = useState({
    text: "",
    userId: "",
  });
  const [fetchValues, setFetchValues] = useState(false);
  const [allData, setAllData] = useState([]);
  console.log("allData ", allData);
  const handleOnChange = (e) => {
    console.log("e.target.value ", e.target.value);
    setInputText({ ...inputText, text: e.target.value });
  };
  const handleOnDelete = async (itemId) => {
    console.log("itemId ", itemId); //24
    const deletedItem = await axios.delete(
      `http://localhost:8080/cruds/deleteRecord?id=${itemId}`
    );
    console.log("deletedItem ", deletedItem.data);
    setFetchValues(!fetchValues);
  };
  const handleOnSubmit = async () => {
    console.log("input Text ", inputText);
    //{text:"hello",userId:""}
    const crudValues = await axios.post(
      `http://localhost:8080/cruds/insert`,
      { text: inputText.text, userId: localStorage.getItem("userId") }
      //{text:"hello",userId:"1"}
    );
    setFetchValues(!fetchValues); //false true false
  };
  const fetchAllRecords = async () => {
    const allRecords = await axios.get(
      "http://localhost:8080/cruds/allItems"
    ); //2 //3
    console.log("allRecords ", allRecords.data);
    setAllData(allRecords.data);
  };
  useEffect(() => {
    fetchAllRecords();
  }, [fetchValues]); //false true
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
          <button className="btn btn-primary mx-2" onClick={handleOnSubmit}>
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
                <span>{item.userId}</span>
              </div>
              <div className="col-sm-3">
                <span>{item.text}</span>
              </div>
              <div
                className="col-sm-1 "
                onClick={() => handleOnDelete(item?.id)}
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
