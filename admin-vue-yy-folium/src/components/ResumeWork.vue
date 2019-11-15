<template>
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title mb-15">
                        Work
                    </h4>
                    <div class="card mb-2">
                        <div class="card-header">
                            <a class="text-body" data-toggle="collapse" aria-expanded="true">
                                <a class="text-muted">경력사항을 입력해주세요.</a>
                            </a>
                        </div>
                        <div id="accordion-2" class="collapse show" data-parent="#accordion-">
                            <div class="card-body">
                                <ResumeTimeline></ResumeTimeline>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import ResumeTimeline from './common/ResumeTimeline'
export default {
    components: {
        ResumeTimeline
    }
}
</script>

<style>

</style>