

var messageApi = Vue.resource('/message{/id}');

Vue.component('request-form', {
    props: ['messages', 'messageAttr'],
    data: function() {
        return {
            text: '',
            id: ''
        }
    },
    watch: {
        messageAttr: function(newVal, oldVal) {
            this.text = newVal.text;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Введите наименование атрибута" v-model="text" />' +
        '<input type="button" value="request" @click="Запросить" />' +
        '</div>',


});


var app = new Vue({
    el: '#app',
    template: '<request-form :messages="messages" />',
    data: {
        messages: []
    }
});
