<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <a href="#" @click.prevent="setPost(null)" class="btn btn-outline-secondary">Back to the list of posts</a>
    </div>
</div>
<div class="row justify-content-center mt-2">
    <div class="col-md-6">
        <h1>
            {{post.title}}
        </h1>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-md-6">
        <strong>
            {{new Date(post.createdAt).toLocaleDateString("en-US")}}
        </strong>
        <p class="text-muted">
            {{post.author}}
        </p>
        <p>
            {{post.content}}
        </p>
    </div>
</div>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <h4>
            Comments
        </h4>
        <div v-for="comment in currentPostComments">
            <h5>
                {{comment.author}}
            </h5>
            <p>
                {{comment.content}}
            </p>
        </div>
    </div>
</div>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <h4>
            New Comment
        </h4>
        <form action="#" @submit.prevent="createComment" method="post">

            <div class="form-group my-1">
                <label for="author">Author:</label>
                <input type="text" class="form-control" name="author" id="author" v-model="createCommentForm.author">
            </div>

            <div class="form-group my-1">
                <label for="content">Comment:</label>
                <textarea name="content" id="content" cols="30" rows="10" class="form-control" v-model="createCommentForm.content"></textarea>
            </div>

            <div class="form-group mt-3">
                <button type="submit" class="btn btn-primary">Comment</button>
            </div>
        </form>
    </div>
</div>