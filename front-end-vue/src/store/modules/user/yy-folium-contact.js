const state = {
    email: "Output My Email",
    tel: "Output my Tel",
    inputValue: {
        firstName:"",
        lastName: "",
        email: "",
        phone: "",
        message: ""
    }
};

const getters = {
    getEmail(state) {
        return state.email;
    },
    getTel(state) {
        return state.tel;
    },
    setInputValue(state) {
        return state.inputValue;
    }
};

export default {
    state,
    getters
}