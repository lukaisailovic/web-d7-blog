<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <div id="app" class="container">
        <div v-if="post==null">
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
                    <a href="#" class="btn btn-primary">New post</a>
                </div>
            </div>
        </div>
        <div v-else>
            <jsp:include page="post.jsp"/>
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
        },
        async mounted(){
            const response = await fetch(API_PATH + 'posts');
            this.posts = await response.json();
        },
        methods:{
            setPost(post){
                this.post = post;
            }
        }
    })
</script>

</html>