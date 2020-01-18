<template>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title mb-15">
                        Contact
                    </h4>
                    <div class="card mb-2">
                        <div class="card-header">
                            <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                <a class="text-muted">연락을 확인해주세요.</a>
                            </a>
                        </div>
                        <div id="accordion-2" class="collapse show" data-parent="#accordion-">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class="bg-dark text-white">
                                            <colgroup>
                                                <col width="5%" />
                                                <col width="15%" />
                                                <col width="15%" />
                                                <col width="15%" />
                                                <col width="50%" />
                                            </colgroup>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Tel</th>
                                                <th>Message</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for="(contact, index) in contacts" v-bind:key="contact.id">
                                                <td>{{ index+1 }}</td>
                                                <td>{{ contact.name }}</td>
                                                <td>{{ contact.email }}</td>
                                                <td>{{ contact.tel }}</td>
                                                <td>{{ contact.message }}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex';
export default {
    computed: {
        ...mapState("contact",['contacts'])
    },
    methods: {
        ...mapMutations("contact",['getContacts'])
    },
    mounted() {
        this.getContacts()
    }
}
</script>

<style>

</style>