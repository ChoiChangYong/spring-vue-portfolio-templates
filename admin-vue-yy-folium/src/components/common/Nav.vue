<template>
    <treeNav
    :left="left"
  ></treeNav>
</template>

<script>
import treeNav from 'vue-tree-nav'

export default {
    components: {
      treeNav
    },
    data: () => {
        return {
            left: [
                {
                    label: 'Home',
                    icon: 'home',
                    href: '#/home'
                }, 
                {
                    label: 'Animals',
                    children: [
                        {
                        label: 'Elephant',
                        href: '#/animals/elephant'
                        }, {
                        label: 'Lion',
                        href: '#/animals/lion'
                        }, {
                        label: 'Bear',
                        href: '#/animals/bear'
                        }, {
                        label: 'Eagle',
                        href: '#/animals/eagle'
                        }, {
                        label: 'Wolf',
                        href: '#/animals/wolf'
                        }
                    ]
                }
            ]
        }
    }
}
</script>

<style>

</style>