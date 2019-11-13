const state = {
    inputValue: {
        tilte:"Input Title",
        intro: "Input Intro",
        subIntro: "Input SubIntro",
        job: ["Input Job"],
    }
};

const getters = {
    setInputValue(state) {
        return state.name;
    },
};

const mutations = {
}


export default {
    state,
    getters,
    mutations
}