const state = {
    intro: "이쁜 나뇽이와 멋진 용용이",
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