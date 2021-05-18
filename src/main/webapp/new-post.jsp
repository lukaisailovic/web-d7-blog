<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <a href="#" @click.prevent="setPost(null);setCreating(false)" class="btn btn-outline-secondary">Back to the list of posts</a>
    </div>
</div>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <h1>
            Create new post
        </h1>
    </div>
</div>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <form action="#" @submit.prevent="createPost" method="post">

            <div class="form-group my-1">
                <label for="author">Author:</label>
                <input type="text" class="form-control" v-model="createPostForm.author" name="author" id="author">
            </div>

            <div class="form-group my-1">
                <label for="title">Title:</label>
                <input type="text" class="form-control" v-model="createPostForm.title" name="title" id="title">
            </div>

            <div class="form-group my-1">
                <label for="content">Content:</label>
                <textarea name="content" id="content" cols="30" rows="10" class="form-control" v-model="createPostForm.content"></textarea>
            </div>

            <div class="form-group mt-3">
                <button type="submit" class="btn btn-primary">Save Post</button>
            </div>
        </form>
    </div>
</div>