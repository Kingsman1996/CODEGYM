import React, {useEffect, useState} from "react";
import {useFormik} from "formik";
import {
    Box,
    Button,
    MenuItem,
    TextField,
    CircularProgress,
} from "@mui/material";
import {toast, ToastContainer} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import {useNavigate} from "react-router-dom";

import {axiosInstance} from "../../api/axiosConfig";
import {schema} from "../../service/validateSchema.js";


const AddMedicine = () => {
    const [categories, setCategories] = useState([]);
    const [loadingCategories, setLoadingCategories] = useState(false);
    const [submitting, setSubmitting] = useState(false);
    const [medicines, setMedicines] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchCategories = async () => {
            try {
                setLoadingCategories(true);
                const res = await axiosInstance.get("/categories");
                setCategories(res.data);
            } catch (err) {
                console.error(err);
            } finally {
                setLoadingCategories(false);
            }
        };
        const fetchMedicines = async () => {
            try {
                const res = await axiosInstance.get("/medicines");
                setMedicines(res.data);
            } catch (err) {
                console.error(err);
            }
        };
        fetchMedicines();
        fetchCategories();
    }, []);

    const formik = useFormik({
        initialValues: {
            code: "",
            name: "",
            category: "",
            description: "",
            quantity: "",
            price: "",
            importDate: "",
        },
        validationSchema: schema,
        onSubmit: async (values) => {
            setSubmitting(true);
            try {
                const maxId = medicines.length > 0 ? Math.max(...medicines.map(m => m.id)) : 0;
                const newId = maxId + 1;
                await axiosInstance.post("/medicines", { id: newId, ...values });
                toast.success("Thêm sản phẩm thành công!");
                setTimeout(() => {
                    navigate("/medicines");
                }, 1500);
            } catch (err) {
                console.error(err);
            } finally {
                setSubmitting(false);
            }
        }

    });

    if (loadingCategories) {
        return (
            <Box sx={{display: "flex", justifyContent: "center", mt: 4}}>
                <CircularProgress/>
            </Box>
        );
    }

    return (
        <>
            <Box
                component="form"
                sx={{maxWidth: 600, mx: "auto", mt: 4, display: "flex", flexDirection: "column", gap: 2}}
                onSubmit={formik.handleSubmit}
                noValidate
            >
                <TextField
                    fullWidth
                    id="code"
                    name="code"
                    label="Mã thuốc"
                    value={formik.values.code}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.code && Boolean(formik.errors.code)}
                    helperText={formik.touched.code && formik.errors.code}
                />

                <TextField
                    fullWidth
                    id="name"
                    name="name"
                    label="Tên thuốc"
                    value={formik.values.name}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.name && Boolean(formik.errors.name)}
                    helperText={formik.touched.name && formik.errors.name}
                />

                <TextField
                    select
                    fullWidth
                    id="category"
                    name="category"
                    label="Chủng loại"
                    value={formik.values.category}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.category && Boolean(formik.errors.category)}
                    helperText={formik.touched.category && formik.errors.category}
                >
                    <MenuItem value="">Chọn chủng loại</MenuItem>
                    {categories.map((cat) => (
                        <MenuItem key={cat.id} value={cat.name}>
                            {cat.name}
                        </MenuItem>
                    ))}
                </TextField>

                <TextField
                    fullWidth
                    id="description"
                    name="description"
                    label="Mô tả"
                    multiline
                    rows={3}
                    value={formik.values.description}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.description && Boolean(formik.errors.description)}
                    helperText={formik.touched.description && formik.errors.description}
                />

                <TextField
                    fullWidth
                    id="quantity"
                    name="quantity"
                    label="Số lượng"
                    type="number"
                    value={formik.values.quantity}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.quantity && Boolean(formik.errors.quantity)}
                    helperText={formik.touched.quantity && formik.errors.quantity}
                />

                <TextField
                    fullWidth
                    id="price"
                    name="price"
                    label="Giá (VND)"
                    type="number"
                    value={formik.values.price}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.price && Boolean(formik.errors.price)}
                    helperText={formik.touched.price && formik.errors.price}
                />

                <TextField
                    fullWidth
                    id="importDate"
                    name="importDate"
                    label="Ngày nhập"
                    type="date"
                    value={formik.values.importDate || ""}
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                    error={formik.touched.importDate && Boolean(formik.errors.importDate)}
                    helperText={formik.touched.importDate && formik.errors.importDate}
                    InputLabelProps={{
                        shrink: true,
                    }}
                />


                <Button
                    color="primary"
                    variant="contained"
                    type="submit"
                    disabled={submitting}
                    sx={{mt: 2}}
                >
                    {submitting ? "Đang gửi..." : "Thêm"}
                </Button>
            </Box>
            <ToastContainer
                position="top-right"
                autoClose={3000}
                hideProgressBar={false}
                newestOnTop={false}
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="colored"
            />
        </>
    );
};

export default AddMedicine;
