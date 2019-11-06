const state = {
    intro: "Insert Intro",
    subIntro: "Insert SubIntro"
};

const getters = {
    getIntro(state) {
        return state.intro;
    },
    getSubIntro(state) {
        return state.subIntro;
    }
};

export default {
    state,
    getters
}