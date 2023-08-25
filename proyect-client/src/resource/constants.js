import { Select, Spin, Tooltip } from "antd";

export const JWT_TOKEN = "accessToken";
export const BACKEND_URL = (process.env.REACT_APP_API_BASE_URL || "http://localhost:8080/api") + "/v1";

export const Messages = {
    error404: "No se ha encontrado el recurso solicitado.",
};
export function JWT_HEADER() {
    let config = {
        headers: { Authorization: "" },
    };

    if (localStorage.getItem(JWT_TOKEN))
        config.headers.Authorization = `Bearer ${localStorage.getItem(JWT_TOKEN)}`;
    return config;
}

export function Loading({ children, loading }) {
    return (
        <Spin tip="Cargando..." size="large" spinning={loading}>
            {children}
        </Spin>
    );
}

export function SearchSelect({ onChange, dataset, value, disabled, mode }) {
    let tooltip = "";
    let style = { width: "100%" };

    if (!value) value = null;
    else {
        tooltip = dataset.find((el) => el.id === value);
        tooltip = tooltip ? tooltip.description : "";
    }

    if (!onChange) onChange = (value) => {
        return value;
    };

    return (
        <Tooltip title={tooltip}>
            <Select mode={mode ? mode : false} disabled={disabled} allowClear showSearch placeholder="Selecciona una opción" optionFilterProp="children" onChange={onChange} value={value} style={style} >
                {dataset.map((element) => {
                    return (
                        <Select.Option key={element.id} title={element.description} value={element.id} >
                            {element.description}
                        </Select.Option>
                    );
                })}
            </Select>
        </Tooltip>
    );
}