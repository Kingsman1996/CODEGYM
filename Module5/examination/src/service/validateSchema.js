import * as yup from "yup";

export const schema = yup.object({
    code: yup.string()
        .required("Mã sản phẩm là bắt buộc")
        .matches(/^PROD-\d{4}$/, "Mã sản phẩm phải đúng định dạng PROD-XXXX (X là số)"),
    name: yup.string().required("Tên sản phẩm là bắt buộc"),
    category: yup.string().required("Thể loại là bắt buộc"),
    description: yup.string().required("Mô tả là bắt buộc"),
    quantity: yup.number()
        .typeError("Số lượng phải là một số")
        .required("Số lượng là bắt buộc")
        .integer("Số lượng phải là số nguyên")
        .min(1, "Số lượng phải lớn hơn 0"),
    price: yup.number()
        .typeError("Giá phải là một số")
        .required("Giá là bắt buộc")
        .min(0, "Giá không được âm"),
    importDate: yup.date()
        .required("Ngày nhập là bắt buộc")
        .max(new Date(), "Ngày nhập không được lớn hơn ngày hiện tại"),
}).required();
