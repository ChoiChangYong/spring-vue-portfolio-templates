<template>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title mb-15">
                   Education
                </h4>
                <div class="card mb-2">
                    <div class="card-header">
                        <a class="text-body" data-toggle="collapse" aria-expanded="true">
                            <a class="text-muted">학력사항을 입력해주세요.</a>
                        </a>
                    </div>
                    <div id="accordion-2" class="collapse show" data-parent="#accordion-">
                        <div class="card-body">
                            <!-- Ibox content -->
                            <div class="ibox-content" id="ibox-content">
                                <div id="vertical-timeline" class="vertical-container light--timeline">
                                    <div class="vertical-timeline-block">
                                        <div class="vertical-timeline-icon bg-info btn-floating pulse"></div>

                                        <div class="vertical-timeline-content">
                                            <div class="mb-2">
                                                <mark>2016.03.01 ~ 2020.02.21</mark>
                                            </div>
                                            <div class="mb-2">
                                                <h5>동의대학교</h5>
                                                <strong>컴퓨터소프트웨어공학과</strong>
                                            </div>
                                            <div>
                                                <p>4년동안 열심히 했습니다.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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

export default {
    mounted() {
        this.sessionCheck()
    }
}
</script>

<style>

</style>