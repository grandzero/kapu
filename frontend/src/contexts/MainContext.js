import {createContext, useState, useEffect} from 'react';
import axios from 'axios';
const MainContext = createContext(null);

export const MainProvider = ({children}) =>{
    const [searchOption, setSearchOption] = useState("desc")
    const [ls, setLs] = useState([]);
    const [detailsModal, setDetailsModal] = useState({});
    const [showDetailsModal, setShowDetailsModal] = useState(false);


    useEffect(() => {
        axios.get("http://localhost:8080/all").then( res => {
            setLs(res.data);
        });

    }, [])



    const values = {
    showDetailsModal,
    setShowDetailsModal,
    searchOption,
    setSearchOption,
    ls, 
    setLs,
    detailsModal,
    setDetailsModal
};


return (
    <MainContext.Provider value={values}>{children}</MainContext.Provider>
)

}

export default MainContext;