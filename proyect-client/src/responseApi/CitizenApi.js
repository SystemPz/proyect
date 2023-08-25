import ApiCall from "../resource/apicall";
const controller = "citizens";

export default {
    newCitizen: async (form) => {
        if (!form.name) form.name = 0;
        if (!form.firstLastName) form.firstLastName = "";
        if (!form.secondLastName) form.secondLastName = "";
        if (!form.status) form.status = false;
        if (!form.address) form.address = [];
        console.log(JSON.stringify(form.address))
        let response = { success: true };
        const method = `addCitizen`;
        try {
            const apiResponse = await ApiCall.post(controller, method, form);
            response.message = apiResponse.data;
        } catch (error) {
            response = ApiCall.handleCatch(error);
        }
        return response;
    },
    getCitizenAll: async (id) => {
        if (!id) id = 0;
        let response = { success: true };
        const method = `listCitizen/${id}`;
        try {
            const apiResponse = await ApiCall.get(controller, method);
            response.citizens = apiResponse.data;
        } catch (error) {
            response = ApiCall.handleCatch(error);
            response.citizens = [];
        }
        return response;
    },
    deleteCitizen: async (id) => {
        if (!id) id = 0;
        let response = { success: true };
        const method = `delCitizen/${id}`;
        try {
            const apiResponse = await ApiCall.get(controller, method);
            response.message = apiResponse.data;
        } catch (error) {
            response = ApiCall.handleCatch(error);
        }
        return response;
    },
}