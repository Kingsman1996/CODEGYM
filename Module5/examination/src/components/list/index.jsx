import React, {useEffect, useState} from "react";
import {
    Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper,
    Button, TextField, MenuItem, Typography, Box, CircularProgress
} from "@mui/material";

import {useNavigate} from "react-router-dom";
import {axiosInstance} from "../../api/axiosConfig";

const MedicineList = () => {
    const [medicines, setMedicines] = useState([]);
    const [filteredMedicines, setFilteredMedicines] = useState([]);
    const [categories, setCategories] = useState([]);

    const [searchName, setSearchName] = useState("");
    const [searchCategory, setSearchCategory] = useState("");

    const [loading, setLoading] = useState(false);

    const navigate = useNavigate();

    useEffect(() => {
        const fetchData = async () => {
            try {
                setLoading(true);
                const [catRes, medRes] = await Promise.all([
                    axiosInstance.get("/categories"),
                    axiosInstance.get("/medicines"),
                ]);
                setCategories(catRes.data);
                const sortedMeds = medRes.data.sort((a, b) => a.name.localeCompare(b.name));
                setMedicines(sortedMeds);
                setFilteredMedicines(sortedMeds);
            } catch (err) {
                console.error(err);
            } finally {
                setLoading(false);
            }
        };
        fetchData();
    }, []);

    useEffect(() => {
        let filtered = medicines;

        if (searchName.trim() !== "") {
            filtered = filtered.filter(med =>
                med.name.toLowerCase().includes(searchName.toLowerCase())
            );
        }

        if (searchCategory !== "") {
            filtered = filtered.filter(med => med.category === searchCategory);
        }

        setFilteredMedicines(filtered);
    }, [searchName, searchCategory, medicines]);

    if (loading) {
        return (
            <Box sx={{display: "flex", justifyContent: "center", mt: 4}}>
                <CircularProgress/>
            </Box>
        );
    }

    return (
        <>
            <Box sx={{maxWidth: 900, mx: "auto", mt: 2, mb: 2, display: "flex", gap: 2, flexWrap: "wrap"}}>
                <TextField
                    label="Tìm kiếm theo tên thuốc"
                    variant="outlined"
                    value={searchName}
                    onChange={e => setSearchName(e.target.value)}
                    sx={{flex: 1, minWidth: 200}}
                />

                <TextField
                    label="Loại thuốc"
                    variant="outlined"
                    select
                    value={searchCategory}
                    onChange={e => setSearchCategory(e.target.value)}
                    sx={{width: 200}}
                >
                    <MenuItem value="">Tất cả</MenuItem>
                    {categories.map(cat => (
                        <MenuItem key={cat.id} value={cat.name}>
                            {cat.name}
                        </MenuItem>
                    ))}
                </TextField>

                <Button variant="contained" color="primary" onClick={() => navigate("/medicines/create")}>
                    Thêm mới thuốc
                </Button>
            </Box>

            <Paper sx={{maxWidth: 900, mx: "auto", mt: 1}}>
                {filteredMedicines.length > 0 ? (
                    <TableContainer>
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell>ID</TableCell>
                                    <TableCell>Mã</TableCell>
                                    <TableCell>Tên</TableCell>
                                    <TableCell>Chủng loại</TableCell>
                                    <TableCell>Mô tả</TableCell>
                                    <TableCell>Số lượng</TableCell>
                                    <TableCell>Giá (VND)</TableCell>
                                    <TableCell>Ngày nhập</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {filteredMedicines.map(med => (
                                    <TableRow key={med.id}>
                                        <TableCell>{med.id}</TableCell>
                                        <TableCell>{med.code}</TableCell>
                                        <TableCell>{med.name}</TableCell>
                                        <TableCell>{med.category}</TableCell>
                                        <TableCell>{med.description}</TableCell>
                                        <TableCell>{med.quantity}</TableCell>
                                        <TableCell>{med.price.toLocaleString()}</TableCell>
                                        <TableCell>{med.importDate}</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                ) : (
                    <Typography variant="h6" sx={{p: 4, textAlign: "center"}}>
                        Không tìm thấy thuốc nào phù hợp với tiêu chí tìm kiếm.
                    </Typography>
                )}
            </Paper>
        </>
    );
};

export default MedicineList;
