const state = {
    name: "Input Name",
    position: "Input Position",
    gender : "Input Gender",
    email : "Input Email",
    tel : "Input Tel"
};

const getters = {
    getName(state) {
        return state.name;
    },
    getPosition(state) {
        return state.position;
    },
    getGender(state) {
        return state.gender;
    },
    getEmail(state) {
        return state.email;
    },
    getTel(state) {
        return state.tel;
    }
};

export default {
    state,
    getters
}