import Alerts from "../resource/alerts";
import CitizenApi from "../responseApi/CitizenApi";

export default {
    newCitizen: async (form) => {
        const response = await CitizenApi.newCitizen(form);
        if (!response.success) Alerts.error("Ha ocurrido un error", response.message);
        return response;
    },
    getCitizenAll: async (id) => {
        const response = await CitizenApi.getCitizenAll(id);
        if (!response.success) Alerts.error("Ha ocurrido un error", response.message);
        return response;
    },
    deleteCitizen: async (id) => {
        const response = await CitizenApi.deleteCitizen(id);
        if (!response.success) Alerts.error("Ha ocurrido un error", response.message);
        return response;
    },
}