<?php
include_once 'header.php';
?>
<section class="main-container">
    <div class="main-wrapper">
        <h2>
            Post
        </h2>
        <div class="notice">
            <?php
            if (isset($_GET['post'])) {
                $postCheck = $_GET['post'];
                if ($postCheck == "empty") {
                    echo "<p>[ You did not fill in all the fields ]</p>";
                } elseif ($postCheck == "char") {
                    echo "<p>[ Please change special characters ]</p>";
                } elseif ($postCheck == "error") {
                    echo "<p>[ Please relogin ]</p>";
                } elseif ($postCheck == "success") {
                    echo "<p>[ Posting... ]</p>";
                }
            }
            ?>
        </div>
        <form class="post-form" action="includes/post.php" method="POST">
            <div>
                <?php
                if (isset($_GET ['title'])) {
                    $title = $_GET ['title'];
                    echo '<input class="form-control" type="text" name="title" placeholder="Title">' . $title . ' <br> ';
                } else {
                    echo ' <input class="form-control" type="text" name="title" placeholder="Title"> <br> ';
                }
                if (isset ($_GET ['content'])) {
                    $content = $_GET ['content'];
                    echo ' <textarea class="form-control" name="content" placeholder="content" ></textarea>' . $content . ' <br> ';
                } else {
                    echo ' <textarea class="form-control" name="content" placeholder="Content"></textarea> <br> ';
                }
                $date = strval(date("e T r"));
                echo "<div class='postSet-time'>$date</div>" . '
                <br>' . '
                <button type="submit" name="post">Post</button>';
                ?>
            </div>
        </form>
    </div>
</section>
<?php
include_once 'footer.php';
?>
