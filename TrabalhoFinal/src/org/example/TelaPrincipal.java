package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class TelaLogin extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;

    public TelaLogin() {
        setTitle("Login - SEONG AUTO PARTS");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo de usuário
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel("Usuário:"), gbc);

        userField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painel.add(userField, gbc);

        // Campo de senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("Senha:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painel.add(passwordField, gbc);

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE); // Define a cor de fundo do botão
        loginButton.setForeground(Color.WHITE); // Define a cor do texto do botão para branco
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(loginButton, gbc);

        // Adiciona ação ao botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        add(painel);
        setVisible(true);
    }

    private void realizarLogin() {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        // Lógica simples de validação de login (substitua conforme necessário)
        if (username.equals("admin") && password.equals("admin")) {
            // Se o login for bem-sucedido, abre a TelaPrincipal
            new TelaPrincipal();
            dispose(); // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogin();
            }
        });
    }
}

public class TelaPrincipal extends JFrame {
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Colaborador> colaboradores = new ArrayList<>();
    private List<Produto> carrinho = new ArrayList<>();
    private JTextArea carrinhoTextArea;

    public TelaPrincipal() {
        setTitle("SEONG AUTO PARTS");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Vitrine", criarPainelProdutos());
        tabbedPane.addTab("Carrinho", criarPainelCarrinho());
        tabbedPane.addTab("Pagamento", criarPainelPagamento());
        tabbedPane.addTab("Fornecedores", criarPainelFornecedores());
        tabbedPane.addTab("Clientes", criarPainelClientes());
        tabbedPane.addTab("Colaboradores", criarPainelColaboradores());
        tabbedPane.addTab("Financeiro", criarPainelFinanceiro());
        tabbedPane.addTab("Relatórios", criarPainelRelatorios());
        tabbedPane.addTab("Estoque", criarPainelEstoque());
        tabbedPane.addTab("Ferramentas", criarPainelFerramentas());


        add(tabbedPane);
        setVisible(true);
    }

    private JPanel criarPainelFornecedores() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel principal como branco

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.setBackground(Color.WHITE); // Define o fundo do painel de formulário como branco
        formPanel.add(new JLabel("Nome da Empresa:"));
        JTextField nomeEmpresaField = new JTextField();
        formPanel.add(nomeEmpresaField);

        formPanel.add(new JLabel("Código:"));
        JTextField codigoField = new JTextField();
        formPanel.add(codigoField);

        formPanel.add(new JLabel("CNPJ:"));
        JTextField cnpjField = new JTextField();
        formPanel.add(cnpjField);

        formPanel.add(new JLabel("Endereço:"));
        JTextField enderecoField = new JTextField();
        formPanel.add(enderecoField);

        formPanel.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        formPanel.add(telefoneField);

        formPanel.add(new JLabel("Razão Social:"));
        JTextField razaoSocialField = new JTextField();
        formPanel.add(razaoSocialField);

        panel.add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco

        JButton btnAdicionar = new JButton("Adicionar Fornecedor");
        btnAdicionar.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnAdicionar.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        Dimension btnSize = new Dimension(200, 40); // Tamanho preferencial do botão
        btnAdicionar.setPreferredSize(btnSize);

        JButton btnListar = new JButton("Listar Fornecedores");
        btnListar.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnListar.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        btnListar.setPreferredSize(btnSize);

        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnListar);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeEmpresa = nomeEmpresaField.getText().trim();
                String codigo = codigoField.getText().trim();
                String cnpj = cnpjField.getText().trim();
                String endereco = enderecoField.getText().trim();
                String telefone = telefoneField.getText().trim();
                String razaoSocial = razaoSocialField.getText().trim();

                if (!nomeEmpresa.isEmpty() && !codigo.isEmpty() && !cnpj.isEmpty() && !endereco.isEmpty() && !telefone.isEmpty() && !razaoSocial.isEmpty()) {
                    fornecedores.add(new Fornecedor(nomeEmpresa, codigo, cnpj, endereco, telefone, razaoSocial));
                    textArea.append("Fornecedor adicionado: " + nomeEmpresa + " (Código: " + codigo + ")\n");
                    nomeEmpresaField.setText("");
                    codigoField.setText("");
                    cnpjField.setText("");
                    enderecoField.setText("");
                    telefoneField.setText("");
                    razaoSocialField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Fornecedor fornecedor : fornecedores) {
                    textArea.append("Nome da Empresa: " + fornecedor.getNomeEmpresa() + ", Código: " + fornecedor.getCodigo() + ", CNPJ: " + fornecedor.getCnpj() + ", Endereço: " + fornecedor.getEndereco() + ", Telefone: " + fornecedor.getTelefone() + ", Razão Social: " + fornecedor.getRazaoSocial() + "\n");
                }
            }
        });

        return panel;
    }


    private JPanel criarPainelClientes() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel principal como branco

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBackground(Color.WHITE); // Define o fundo do painel do formulário como branco

        formPanel.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Endereço:"));
        JTextField enderecoField = new JTextField();
        formPanel.add(enderecoField);

        formPanel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        formPanel.add(cpfField);

        formPanel.add(new JLabel("Código:"));
        JTextField codigoField = new JTextField();
        formPanel.add(codigoField);

        formPanel.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        formPanel.add(telefoneField);

        panel.add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco

        JButton btnAdicionar = new JButton("Adicionar Cliente");
        btnAdicionar.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnAdicionar.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        buttonPanel.add(btnAdicionar);

        JButton btnListar = new JButton("Listar Clientes");
        btnListar.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnListar.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        buttonPanel.add(btnListar);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText().trim();
                String endereco = enderecoField.getText().trim();
                String cpf = cpfField.getText().trim();
                String codigo = codigoField.getText().trim();
                String telefone = telefoneField.getText().trim();

                if (!nome.isEmpty() && !endereco.isEmpty() && !cpf.isEmpty() && !codigo.isEmpty() && !telefone.isEmpty()) {
                    clientes.add(new Cliente(nome, endereco, cpf, codigo, telefone));
                    textArea.append("Cliente adicionado: " + nome + " (Código: " + codigo + ")\n");
                    nomeField.setText("");
                    enderecoField.setText("");
                    cpfField.setText("");
                    codigoField.setText("");
                    telefoneField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Cliente cliente : clientes) {
                    textArea.append("Nome: " + cliente.getNome() + ", Endereço: " + cliente.getEndereco() + ", CPF: " + cliente.getCpf() + ", Código: " + cliente.getCodigo() + ", Telefone: " + cliente.getTelefone() + "\n");
                }
            }
        });

        return panel;
    }


    private JPanel criarPainelProdutos() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel produtosPanel = new JPanel(new GridLayout(0, 2));
        JScrollPane scrollPane = new JScrollPane(produtosPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Adicionando produtos para demonstração
        produtos.add(new Produto("Pastilha De Freio", "1", "150.00", "Frasle"));
        produtos.add(new Produto("Embreagem", "2", "1600.00", "PHC"));
        produtos.add(new Produto("Biela", "3", "199.00", "Frontier"));
        produtos.add(new Produto("Cabecote", "4", "2499.00", "Roc"));

        for (Produto produto : produtos) {
            JPanel produtoPanel = new JPanel(new BorderLayout());
            produtoPanel.setBorder(BorderFactory.createTitledBorder(produto.getNomeProduto()));
            produtoPanel.setBackground(Color.WHITE); // Define o fundo do painel como branco
            produtoPanel.add(new JLabel("Preço: R$ " + produto.getPreco()), BorderLayout.CENTER);

            JButton adicionarButton = new JButton("Adicionar ao Carrinho");
            adicionarButton.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
            adicionarButton.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
            produtoPanel.add(adicionarButton, BorderLayout.SOUTH);

            adicionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    adicionarAoCarrinho(produto);
                }
            });

            produtosPanel.add(produtoPanel);
        }

        return panel;
    }


    private JPanel criarPainelColaboradores() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel principal como branco

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBackground(Color.WHITE); // Define o fundo do painel de formulário como branco
        formPanel.add(new JLabel("Nome:"));
        JTextField nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Endereço:"));
        JTextField enderecoField = new JTextField();
        formPanel.add(enderecoField);

        formPanel.add(new JLabel("CPF:"));
        JTextField cpfField = new JTextField();
        formPanel.add(cpfField);

        formPanel.add(new JLabel("Cargo:"));
        JTextField cargoField = new JTextField();
        formPanel.add(cargoField);

        formPanel.add(new JLabel("Telefone:"));
        JTextField telefoneField = new JTextField();
        formPanel.add(telefoneField);

        panel.add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco
        JButton btnAdicionar = new JButton("Adicionar Colaborador");
        JButton btnListar = new JButton("Listar Colaboradores");

        // Define a cor de fundo e a cor do texto dos botões
        btnAdicionar.setBackground(Color.BLUE);
        btnAdicionar.setForeground(Color.WHITE);
        btnListar.setBackground(Color.BLUE);
        btnListar.setForeground(Color.WHITE);

        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnListar);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText().trim();
                String endereco = enderecoField.getText().trim();
                String cpf = cpfField.getText().trim();
                String cargo = cargoField.getText().trim();
                String telefone = telefoneField.getText().trim();

                if (!nome.isEmpty() && !endereco.isEmpty() && !cpf.isEmpty() && !cargo.isEmpty() && !telefone.isEmpty()) {
                    colaboradores.add(new Colaborador(nome, endereco, cpf, cargo, telefone));
                    textArea.append("Colaborador adicionado: " + nome + " (Cargo: " + cargo + ")\n");
                    nomeField.setText("");
                    enderecoField.setText("");
                    cpfField.setText("");
                    cargoField.setText("");
                    telefoneField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Colaborador colaborador : colaboradores) {
                    textArea.append("Nome: " + colaborador.getNome() + ", Endereço: " + colaborador.getEndereco() + ", CPF: " + colaborador.getCpf() + ", Cargo: " + colaborador.getCargo() + ", Telefone: " + colaborador.getTelefone() + "\n");
                }
            }
        });

        return panel;
    }


    private JPanel criarPainelFinanceiro() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnResumoFinanceiro = new JButton("Resumo Financeiro");
        btnResumoFinanceiro.setBackground(Color.BLUE); // Define a cor de fundo como azul
        btnResumoFinanceiro.setForeground(Color.WHITE); // Define a cor do texto como branco para melhor visibilidade
        btnResumoFinanceiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulação de um resumo financeiro simples
                textArea.setText("Resumo Financeiro:\n\n" +
                        "Receitas do Mês: R$ 100.000,00\n" +
                        "Despesas do Mês: R$ 60.000,00\n" +
                        "Lucro do Mês: R$ 40.000,00\n\n" +
                        "Saldo Atual: R$ 150.000,00");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnResumoFinanceiro);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }



    private JPanel criarPainelVendas() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Painel de Vendas em construção");
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JPanel criarPainelRelatorios() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // FlowLayout centralizado com espaçamento de 10 pixels
        panel.setBackground(Color.WHITE); // Define o fundo do painel como branco

        JButton btnColaboradores = new JButton("Colaboradores");
        JButton btnFaturamento = new JButton("Faturamento");
        JButton btnEstoque = new JButton("Estoque");

        Dimension btnSize = new Dimension(150, 30); // Tamanho preferencial dos botões

        btnColaboradores.setPreferredSize(btnSize);
        btnFaturamento.setPreferredSize(btnSize);
        btnEstoque.setPreferredSize(btnSize);

        // Definir a cor dos botões
        btnColaboradores.setBackground(Color.BLUE);
        btnColaboradores.setForeground(Color.WHITE);

        btnFaturamento.setBackground(Color.BLUE);
        btnFaturamento.setForeground(Color.WHITE);

        btnEstoque.setBackground(Color.BLUE);
        btnEstoque.setForeground(Color.WHITE);

        panel.add(btnColaboradores);
        panel.add(btnFaturamento);
        panel.add(btnEstoque);

        btnColaboradores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Colaboradores ativos: Renally Laryssa, Ivan Duarte.", "Relatório", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnFaturamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O faturamento mensal foi de R$75.855,00", "Relatório", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O estoque total contém 83 Pastilhas de freio, 95 Embreagens, 103 Bielas e 45 Cabecotes", "Relatório", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return panel;
    }



    private JPanel criarPainelEstoque() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel como branco

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnListarEstoque = new JButton("Listar Produtos em Estoque");
        btnListarEstoque.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnListarEstoque.setForeground(Color.WHITE); // Define a cor do texto do botão como branco

        Dimension btnSize = new Dimension(200, 40); // Tamanho preferencial do botão
        btnListarEstoque.setPreferredSize(btnSize);

        btnListarEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulação de listar produtos em estoque
                textArea.setText("Lista de Produtos em Estoque:\n\n");
                for (Produto produto : produtos) {
                    textArea.append("Nome: " + produto.getNomeProduto() + "\n");
                    textArea.append("Código: " + produto.getCodigo() + "\n");
                    textArea.append("Preço: R$ " + produto.getPreco() + "\n");
                    textArea.append("Fornecedor: " + produto.getFornecedor() + "\n\n");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco
        buttonPanel.add(btnListarEstoque);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }



    private JPanel criarPainelPagamento() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel principal como branco

        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.setBackground(Color.WHITE); // Define o fundo do painel de formulário como branco
        formPanel.add(new JLabel("Nome no Cartão:"));
        JTextField nomeCartaoField = new JTextField();
        formPanel.add(nomeCartaoField);

        formPanel.add(new JLabel("Número do Cartão:"));
        JTextField numeroCartaoField = new JTextField();
        formPanel.add(numeroCartaoField);

        formPanel.add(new JLabel("Data de Validade:"));
        JTextField dataValidadeField = new JTextField();
        formPanel.add(dataValidadeField);

        formPanel.add(new JLabel("CVV:"));
        JTextField cvvField = new JTextField();
        formPanel.add(cvvField);

        panel.add(formPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco

        JButton btnFinalizarPagamento = new JButton("Finalizar Pagamento");
        btnFinalizarPagamento.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnFinalizarPagamento.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        buttonPanel.add(btnFinalizarPagamento);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnFinalizarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCartao = nomeCartaoField.getText().trim();
                String numeroCartao = numeroCartaoField.getText().trim();
                String dataValidade = dataValidadeField.getText().trim();
                String cvv = cvvField.getText().trim();

                if (!nomeCartao.isEmpty() && !numeroCartao.isEmpty() && !dataValidade.isEmpty() && !cvv.isEmpty()) {
                    // Simulação de pagamento
                    textArea.setText("Pagamento finalizado com sucesso para o cartão terminado em " + numeroCartao.substring(numeroCartao.length() - 4) + ".");
                    nomeCartaoField.setText("");
                    numeroCartaoField.setText("");
                    dataValidadeField.setText("");
                    cvvField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos do cartão devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return panel;
    }



    private JPanel criarPainelFerramentas() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel como branco

        // Botão para Configurações do Usuário
        JButton btnConfiguracoes = new JButton("Configurações do Usuário");
        btnConfiguracoes.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnConfiguracoes.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        Dimension btnSize = new Dimension(200, 40); // Tamanho preferencial dos botões
        btnConfiguracoes.setPreferredSize(btnSize);
        btnConfiguracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opções de configurações do usuário serão implementadas aqui.", "Configurações do Usuário", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botão para Backup e Restauração
        JButton btnBackup = new JButton("Backup e Restauração");
        btnBackup.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnBackup.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        btnBackup.setPreferredSize(btnSize);
        btnBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opções de backup e restauração serão implementadas aqui.", "Backup e Restauração", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Painel com botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco
        buttonPanel.add(btnConfiguracoes);
        buttonPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre os botões
        buttonPanel.add(btnBackup);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }



    private JPanel criarPainelCarrinho() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Define o fundo do painel como branco

        carrinhoTextArea = new JTextArea(10, 30);
        carrinhoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(carrinhoTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Define o fundo do painel de botões como branco

        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.setBackground(Color.BLUE); // Define a cor de fundo do botão como azul
        btnFinalizarCompra.setForeground(Color.WHITE); // Define a cor do texto do botão como branco
        Dimension btnSize = new Dimension(250, 50); // Tamanho preferencial do botão
        btnFinalizarCompra.setPreferredSize(btnSize);

        buttonPanel.add(btnFinalizarCompra);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnFinalizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });

        return panel;
    }


    private void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
        carrinhoTextArea.append("Produto adicionado ao carrinho: " + produto.getNomeProduto() + " - R$ " + produto.getPreco() + "\n");
    }

    private void finalizarCompra() {
        double total = 0;
        for (Produto produto : carrinho) {
            total += Double.parseDouble(produto.getPreco());
        }
        JOptionPane.showMessageDialog(this, "Total da compra: R$ " + total, "Compra Finalizada", JOptionPane.INFORMATION_MESSAGE);
        carrinho.clear();
        carrinhoTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal();
            }
        });
    }
}

class Fornecedor {
    private String nomeEmpresa;
    private String codigo;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String razaoSocial;

    public Fornecedor(String nomeEmpresa, String codigo, String cnpj, String endereco, String telefone, String razaoSocial) {
        this.nomeEmpresa = nomeEmpresa;
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.razaoSocial = razaoSocial;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
}

class Cliente {
    private String nome;
    private String endereco;
    private String cpf;
    private String codigo;
    private String telefone;

    public Cliente(String nome, String endereco, String cpf, String codigo, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.codigo = codigo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTelefone() {
        return telefone;
    }
}

class Produto {
    private String nomeProduto;
    private String codigo;
    private String preco;
    private String fornecedor;

    public Produto(String nomeProduto, String codigo, String preco, String fornecedor) {
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
        this.preco = preco;
        this.fornecedor = fornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPreco() {
        return preco;
    }

    public String getFornecedor() {
        return fornecedor;
    }
}

class Colaborador {
    private String nome;
    private String endereco;
    private String cpf;
    private String cargo;
    private String telefone;

    public Colaborador(String nome, String endereco, String cpf, String cargo, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }
}