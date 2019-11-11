import toastr from 'toastr'

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
    tosSuccessSubmit() {
        toastr.success("Success Submit","Success Submit");
    }
}


export default {
    state,
    getters,
    mutations
}