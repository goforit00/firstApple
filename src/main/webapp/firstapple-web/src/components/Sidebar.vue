<template>
    <!--<div class="panel panel-default">-->
    <!--<div class="panel-heading">-->
    <!--<h1 class="text-center">已有时长</h1>-->
    <!--</div>-->

    <!--<div class="panel-body">-->
    <!--<h1 class="text-center">{{ time }} 小时</h1>-->
    <!--</div>-->

    <!--</div>-->


    <div panel panel-default>
        <div class="row">
            <div class="span2">
                <ul class="nav nav-pills nav-stacked">
                    <li><a v-link="'/home'">Home</a></li>
                    <li><a v-link="'/time-entries'">Tutorials</a></li>
                    <!--<li><a href="#">Practice Editor </a></li>-->
                    <!--<li><a href="#">Gallery</a></li>-->
                    <!--<li><a href="#">Contact</a></li>-->
                </ul>
            </div>

        </div>
    </div>

</template>

<script>
    export default {
        props: ['time']
    }
</script>
