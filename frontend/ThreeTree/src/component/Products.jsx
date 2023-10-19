/* eslint-disable no-unused-vars */
// import * as React from 'react';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import CssBaseline from '@mui/material/CssBaseline';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Link from '@mui/material/Link';
import {createTheme, ThemeProvider} from '@mui/material/styles';
import {useEffect, useState} from "react";
import TextField from "@mui/material/TextField";
import * as React from "react";


function Copyright() {
    return (
        <Typography variant="body2" color="text.secondary" align="center">
            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

const defaultTheme = createTheme();

const fetchProducts = async () => {
    const response = await fetch('/api/products');
    const products = await response.json();
    return products;
}

export default function Products() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetchProducts().then((products) => {
            console.log(products);
            setProducts(products);
        });
    }, []);


    return (
        <ThemeProvider theme={defaultTheme}>
            <CssBaseline/>
            <main>
                {/* Hero unit */}
                <Box
                    sx={{
                        backgroundImage: `url('https://images.unsplash.com/photo-1603912699214-92627f304eb6?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=2825')`,
                        backgroundSize: 'cover',
                        backgroundRepeat: 'no-repeat',
                        minHeight: '100vh',
                    }}
                >
                    <Typography
                        sx={{
                            position: 'fixed', // This makes the element fixed on the viewport
                            top: 0,            // This positions the button at the top of the viewport
                            right: 0,          // This positions the button to the far right of the viewport
                            zIndex: 1,         // This ensures the button appears above other content
                            padding: '1em'     // Add some spacing from the top and right edges
                        }}
                    >
                    <Button
                        color='primary'
                        size='large'
                        variant='contained'
                        onClick={() => {
                            window.location.href = "/signup"
                        }}
                    >
                        Cart
                    </Button>
                </Typography>
            </Box>

            <Container maxWidth="sm">
                <Typography
                    component="h1"
                    variant="h2"
                    align="center"
                    color="text.primary"
                    gutterBottom
                >
                    Choose your plant
                </Typography>
            </Container>

            <Container sx={{py: 8}} maxWidth="md">
                <Grid container spacing={4}>
                    {products.map((product) => (
                        <Grid item key={product.productId} xs={12} sm={6} md={4}>
                            <Card
                                sx={{height: '100%', display: 'flex', flexDirection: 'column'}}
                            >
                                <CardMedia
                                    component="div"
                                    sx={{
                                        // 16:9
                                        pt: '56.25%',
                                    }}
                                    image={product.image}
                                />
                                <CardContent sx={{flexGrow: 1}}>
                                    <Typography gutterBottom variant="h5" component="h2">
                                        {product.name}
                                    </Typography>
                                    <Typography>
                                        {product.description}
                                    </Typography>
                                </CardContent>
                                <TextField
                                    label="Quantity"
                                    type="number"
                                    value={0}
                                    onChange={() => {
                                    }}
                                    inputProps={{
                                        min: 0,
                                        step: 1,
                                        inputMode: 'numeric',
                                    }}
                                />
                                <CardActions>
                                    <Button size="small">Add to Cart</Button>
                                </CardActions>

                            </Card>
                        </Grid>
                    ))}
                </Grid>
            </Container>
        </main>

    <Box sx={{bgcolor: 'background.paper', p: 6}} component="footer">
        <Typography variant="h6" align="center" gutterBottom>
            Visit Our Store
        </Typography>
        <Typography
            variant="subtitle1"
            align="center"
            color="text.secondary"
            component="p"
        >
            Come see our full selection of plants and accessories at our physical store location.
        </Typography>
        <Copyright/>
    </Box>
    {/* End footer */
    }
</ThemeProvider>
)
    ;
}