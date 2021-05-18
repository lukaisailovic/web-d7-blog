<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <div id="app" class="container">
        <div v-if="post==null && !creating">
            <div class="row justify-content-center mt-5">
                <div class="col-md-6">
                    <h1>
                        All posts
                    </h1>
                </div>
            </div>
            <div class="row justify-content-center mt-3">
                <div class="col col-md-6">
                    <ul class="list-group">
                        <li class="list-group-item" v-for="post in posts">
                            <h5 class="text-muted">
                                <div class="row" >
                                    <div class="col text-start">
                                        <p>
                                            {{post.title}}
                                        </p>
                                    </div>
                                    <div class="col text-end">
                                        <p>
                                            {{new Date(post.createdAt).toLocaleDateString("en-US")}}
                                        </p>
                                    </div>

                                </div>
                            </h5>
                            <p>
                                {{post.content}}
                            </p>
                            <a href="#" @click.prevent="setPost(post)" class="text-decoration-none text-muted">
                                Opsirnije...
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
            <div class="row justify-content-center mt-5">
                <div class="col-md-6">
                    <a href="#" class="btn btn-primary" @click.prevent="setCreating(true)">New post</a>
                </div>
            </div>
        </div>
        <div v-if="post!==null && !creating">
            <jsp:include page="post.jsp"/>
        </div>
        <div v-if="creating">
            <jsp:include page="new-post.jsp"/>
        </div>
    </div>
</body>

<script>
    const API_PATH = 'http://localhost:8080/web_d7/api/';

    let app = new Vue({
        el: '#app',
        data: {
            posts: [],
            post: null,
            creating: false,
            currentPostComments: [],
            createPostForm: {
                author: "",
                title: "",
                content: ""
            },
            createCommentForm: {
                author: "",
                content: ""
            }
        },
        async mounted(){
            const response = await fetch(API_PATH + 'posts');
            this.posts = await response.json();
        },
        methods:{
            async setPost(post){
                this.post = post;
                if (post !== null){
                    const response = await fetch(API_PATH + 'comments?postId='+post.id);
                    this.currentPostComments = await response.json();
                }
            },
            setCreating(value){
                this.creating = value;
                this.createPostForm = {
                    author: "",
                    title: "",
                    content: ""
                }
            },
            async createPost(){
                let response = await fetch(API_PATH + 'posts',{
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(this.createPostForm)
                });
                const content = await response.json();
                this.setCreating(false);
                response = await fetch(API_PATH + 'posts');
                this.posts = await response.json();
            },
            async createComment(){
                let response = await fetch(API_PATH + 'comments',{
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        author: this.createCommentForm.author,
                        content: this.createCommentForm.content,
                        postId: this.post.id,
                    })
                });
                const content = await response.json();
                response = await fetch(API_PATH + 'comments?postId='+this.post.id);
                this.currentPostComments = await response.json();
                this.createCommentForm = {
                    author: "",
                    content: ""
                };
            }
        }
    })
</script>

</html>