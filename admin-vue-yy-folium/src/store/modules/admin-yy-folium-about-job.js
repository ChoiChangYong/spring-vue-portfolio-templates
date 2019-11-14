const state = {
    jobs: [{index: 0, job: ""}]
}
const getters = {
    getJobs(state) {
        return state.jobs
    }
}

const mutations = {
    addRow(state, index) {
        state.jobs.push([{index: index, job: ""}]);
      },
      removeRow(state, index){
        state.jobs.splice(index, 1);
      }
}

export default {
    state,
    getters,
    mutations
}