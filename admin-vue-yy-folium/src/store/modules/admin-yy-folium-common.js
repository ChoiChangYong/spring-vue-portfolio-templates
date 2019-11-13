const state = {
    isActive: false,
};

const getters = {
    getIsActive(state) {
        return state.isActive
    },
}

const mutations = {
    TrriggerActive(state) {
        state.isActive = !state.isActive
    },
    MenuCollaspedActive () {
        state.isActive = !state.isActive
    }
};

export default {
    state,
    getters,
    mutations
}