
const state = {
    inputValue: {
        tilte:"Input Title",
        intro: "Input Intro",
        subIntro: "Input SubIntro",
        job: ["Input Job"],
    },
    // sessionCheck: storage.fetch()
};

const getters = {
    setInputValue(state) {
        return state.name;
    },
};

const mutations = {
    
}


export default {
    // storage,
    state,
    getters,
    mutations
}