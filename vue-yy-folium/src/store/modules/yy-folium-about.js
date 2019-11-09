const state = {
    name: "Insert Name",
    position: "Insert Position",
    gender : "Insert Gender",
    email : "Insert Email",
    tel : "Insert Tel"
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