<template>
  <div class="row">
      <div class="col-12">
          <div class="card">
              <div class="card-body">
                  <div class="edit-table-area">
                      <h4 class="card-title mb-15">
                          Menu
                      </h4>
                      <div class="card mb-2">
                          <div class="card-header">
                              <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                  <a class="text-muted">프로젝트를 등록하시려면 하나 이상의 메뉴가 필요합니다.</a>
                              </a>
                          </div>
                          <div id="accordion-3" class="collapse show" data-parent="#accordion-">
                              <div class="card-body">
                                  <div class="text-right mb-2">
                                      <i class="fas fa-plus-square fa-2x" @click="addMenu"></i>
                                  </div>
                                  <div class="table-responsive">
                                      <table id="basicTableId" class="table table-bordered table-striped">
                                          <colgroup>
                                              <col width="95%" />
                                              <col width="5%" />
                                          </colgroup>
                                          <tr>
                                              <th colspan="2" class="bg-dark text-white">Name</th>
                                          </tr>
                                          <tr v-for="(menu) in portfolioMenus" v-bind:key="menu.id">
                                              <td id="name" class="editMe" ref="name">{{ menu.name }}</td>
                                              <td>
                                                  <i class="fas fa-minus-square fa-2x" @click="deleteMenu(menu.id)"></i>
                                              </td>
                                          </tr>
                                      </table>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="text-right">
                          <button type="button" class="btn btn-primary" @click="submitMenu()">저장</button>
                      </div>
                  </div>
              </div> <!-- end card-body-->
          </div> <!-- end card-->
      </div><!-- end col -->
  </div>
  <!-- end row -->
</template>

<script>
import { mapState, mapMutations, mapActions } from "vuex"
import SimpleTableCellEditor from '../../assets/admin/js/SimpleTableCellEditor'
import $ from "jquery"

export default {
      data() {
        return {
            newMenus: []
        }
    },
    computed: {
        ...mapState("menu",['portfolioMenus'])
    },
    methods: {
        ...mapMutations("menu",['getMenus', 'addMenu', 'updateMenus']),
        ...mapActions("menu",["deleteMenu"]),
        submitMenu(){
            for(var idx = 0; idx < this.portfolioMenus.length; idx++){
                this.newMenus.push(this.portfolioMenus[idx])
            }
            for (var jdx = 0; jdx < this.portfolioMenus.length; jdx++){
                this.newMenus[jdx].name = this.$refs.name[jdx].innerHTML
            }
            this.updateMenus(this.newMenus)
        }
    },
    mounted() {
        this.getMenus()
        new SimpleTableCellEditor("basicTableId").SetEditableClass("editMe"),
        $("#basicTableId").on("cell:edited")
    }

}
</script>
