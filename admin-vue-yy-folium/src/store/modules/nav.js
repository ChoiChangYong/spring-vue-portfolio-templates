const state = {
    isActive: false
}

const mutations = {
    TrriggerActive: (state) => {
        state.isActive = !state.isActive
    },
    
    MenuCollaspedActive: (state) => {
        state.isActive = !state.isActive
    }
}

export default {
    namespaced: true,
    state,
    mutations
}