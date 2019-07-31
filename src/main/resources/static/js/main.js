

var messageApi = Vue.resource('/message{/id}');

Vue.component('message-form', {
    props: ['messages', 'messageApi'],
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
        '<input type="text" placeholder="Введите критерий поиска" v-="text" />' +
        '<input type="button" value="Request" @click="request" />' +
        '</div>',
    methods: {
        save: function() {
            var message = { text: this.text };

                messageApi.save({}, message).then(result =>
                result.json().then(data => {
                    this.messages.push(data);
                this.text = ''
                })
            )

        }
    }
});

Vue.component('message-row', {
    props: ['message'],
    template:
        '<div> {{message}} </div>'
});

Vue.component('messages-list', {
    props: ['messages'],
    template:
    '<div>' +
        '<message-form : messages="messages" />' +
        '<message-row v-for="message in message"  /">' +
        ' </div>',

    created: function() {
            messageApi.get().then(result =>
            result.json().then(data =>
            data.forEach(message => this.messages.push(message))
            )

        )
    }
});


var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: []
    }
});

