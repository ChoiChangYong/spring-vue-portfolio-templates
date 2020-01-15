<template>
    <div class="card-body">
        <div class="edit-table-area">
            <h4 class="card-title mb-15">
                Project
            </h4>
            <div class="card mb-2">
                <div class="card-header">
                    <a class="text-body" data-toggle="collapse" aria-expanded="true">
                        <a class="text-muted">프로젝트를 입력해주세요</a>
                    </a>
                    <div class="text-right float-right">
                        <router-link to="/portfolio/project/add"><i class="fas fa-plus-square fa-2x"></i></router-link>
                    </div>
                </div>
                <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                    <div class="card-body">
                        <div class="card-body" v-for="project in projects" v-bind:key="project.id">
                            <p>{{ project.portfolioMenu.name }}</p>
                            <div class="text-right float-right">
                                <i class="fas fa-pen-square fa-2x mr-3"></i>
                                <i class="fas fa-minus-square fa-2x" @click="deleteProject(project.id)"></i>
                            </div>
                            <h5 class>{{ project.name }}</h5>
                                <carousel :autoplay="true" :nav="false">
                                    <div v-for="image in project.imageUrls" v-bind:key="image.id">
                                        <img v-bind:src="image"/>
                                    </div>
                                </carousel>
                            <p class="card-text mt-2">
                                {{ project.description}}
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import carousel from 'vue-owl-carousel'
import { mapState, mapMutations } from 'vuex'

export default {
    computed: {
        ...mapState("project",['projects'])
    },
    components: { 
        carousel 
    },
    methods: {
        ...mapMutations("project",['getMenus', 'isMenusNull', 'deleteProject']),
        // ...mapActions("project",['sessionCheck'])
    },
    mounted() {
        this.getMenus()
    }
}
</script>

<style>
.img-wrap {
    margin: auto;
    width: auto;
    height: 300px;
    overflow: hidden;
    text-align: center;
}
.project-img {
    width: auto;
    height: 300px;
}
.fa-pen-square {
    color: #ffc107
}
</style>