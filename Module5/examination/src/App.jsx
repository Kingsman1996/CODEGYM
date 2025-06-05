import './App.css';
import {BrowserRouter, Route, Routes} from "react-router";
import MedicineList from "./components/list/index.jsx";
import AddMedicine from "./components/create/index.jsx";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/medicines" element={<MedicineList/>}/>
                    <Route path="/medicines/create" element={<AddMedicine/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
